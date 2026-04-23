class Solution {
    public long[] distance(int[] nums) {
        long[] ans = new long[nums.length];
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!hmap.containsKey(nums[i])){
                hmap.put(nums[i], new ArrayList<>());
            }
            hmap.get(nums[i]).add(i);
        }

        for(List<Integer> list : hmap.values()){
            compute(list, ans);
        }

        return ans;
    }

    public void compute(List<Integer> list, long[] ans){
        int size = list.size();

        // left
        long sum = 0;
        for(int i = 0; i < size; i++){
            int idx = list.get(i);
            ans[idx] += (long)idx * i - sum;
            sum += idx;
        }

        // right
        sum = 0;
        for(int i = size - 1; i >= 0; i--){
            int idx = list.get(i);
            ans[idx] += sum - (long)idx * (size - 1 - i);
            sum += idx;
        }
    }
}