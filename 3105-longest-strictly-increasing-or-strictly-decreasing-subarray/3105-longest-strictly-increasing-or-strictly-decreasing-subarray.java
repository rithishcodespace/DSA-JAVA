class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;

        // search for increasing
        int prev = nums[0], len=0;
        for(int i=1;i<nums.length;i++){
            if(prev < nums[i])len++;
            else{
                max = Math.max(max, len+1);
                len=0;
            }
            prev=nums[i];
        } 
        max = Math.max(max, len+1);

        // search for decreasing
        prev = nums[nums.length-1]; len=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] > prev)len++;
            else{
                max = Math.max(max, len+1);
                len=0;
            }
            prev=nums[i];
        }
        max = Math.max(max, len+1);

        return max;
    }
}