class Solution {
    public int jump(int[] nums) {
        int maxReach = 0, jump = 0;
        for(int i=0;i<nums.length;i++){
            if(i == nums.length-1)return jump;

            int reach = i+nums[i];

            if(maxReach < reach){
                maxReach = reach;
                jump++;
            }
        }

        return jump;
    }
}