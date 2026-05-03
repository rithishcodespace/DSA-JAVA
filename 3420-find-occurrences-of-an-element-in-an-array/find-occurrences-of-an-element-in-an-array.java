class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == x){
                list.add(i);
            }
        }

        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            if(list.size() < queries[i]){
                ans[i] = -1;
            }
            else{
                int idx = 0;
                for(int j=0;j<queries[i];j++){
                    idx = list.get(j);
                }
                ans[i] = idx;
            }
        }
        return ans;
    }
}