class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int minSoFar = nums[nums.length-1], maxSoFar = nums[0], l = -1, r = -1;

        // find r
        for(int i=1;i<nums.length;i++){
            if(nums[i] < maxSoFar){
                r=i;
            }
            else{
                maxSoFar = nums[i];
            }
        }

        // find l
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] > minSoFar){
                l=i;
            }
            else{
                minSoFar = nums[i];
            }
        }

        return (l != -1 && r != -1) ? r-l+1 : 0;
    }
}