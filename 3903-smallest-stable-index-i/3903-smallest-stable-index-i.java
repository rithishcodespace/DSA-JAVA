class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            maxs[i] = max;
        }

        for(int i=nums.length-1;i>=0;i--){
            min = Math.min(min,nums[i]);
            mins[i] = min;
        }

        int idx = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int diff = maxs[i] - mins[i];
            if(diff <= k){
               idx = Math.min(idx,i);
            }
        }

        return (idx == Integer.MAX_VALUE) ? -1 : idx;
    }
}