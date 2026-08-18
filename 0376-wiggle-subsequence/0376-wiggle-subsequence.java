class Solution {
    public int wiggleMaxLength(int[] nums) {
        int prevSign = -1, len=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1])continue;
            int currSign = (nums[i] > nums[i-1]) ? 1 : 0;

            if(prevSign == -1 || currSign != prevSign){
                len++;
                prevSign = currSign;
            }
        }

        return len;
    }
}