class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hmap.containsKey(nums[i])){
                hmap.put(nums[i], new ArrayList<>());
            }
            hmap.get(nums[i]).add(i);
        }
        for(int i=0;i<queries.length;i++){
            int num = nums[queries[i]];
            List<Integer> list = hmap.get(num);
            // find num in list using binary search
            int idx = bs(list, queries[i]);
            int size = list.size();
            int n = nums.length;

            if(size == 1){
                ans.add(-1);
            }
            else{
                // get circular neighbors
                int left  = list.get((idx - 1 + size) % size);
                int right = list.get((idx + 1) % size);

                // compute circular distances
                int d1 = Math.abs(queries[i] - left);
                int d2 = Math.abs(queries[i] - right);

                d1 = Math.min(d1, n - d1);
                d2 = Math.min(d2, n - d2);

                ans.add(Math.min(d1, d2));
            }

        }
        return ans;
    }
    public int bs(List<Integer> list, int num){
        int l=0, r=list.size()-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(list.get(mid) == num){
                return mid;
            }
            else if(list.get(mid) < num){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;
    }
}