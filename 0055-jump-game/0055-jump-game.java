class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        for(int i=0;i<nums.length;i++){
            int reach = i+nums[i];
            if(reach > maxIdx){
                maxIdx = reach;
            }

            if(i == maxIdx){
                if(i == nums.length-1)return true;
                else return false;
            }
        }

        return true;
    }
}