class Solution {
    public boolean predictTheWinner(int[] nums){
        Integer[][] dp = new Integer[nums.length][nums.length];
        return solve(0, nums.length - 1, nums, dp) >= 0;
    }
    // 1'st player - 2'nd players score
    public int solve(int i, int j, int[] nums, Integer[][] dp){ 
        if(i == j){ // i have one option to pick (deciding factor)
            return nums[i];
        }

        if(dp[i][j] != null)return dp[i][j];

        int pickLeft = nums[i] - solve(i+1, j, nums, dp); 
        int pickRight = nums[j] - solve(i, j-1, nums, dp);

        dp[i][j] = Math.max(pickLeft, pickRight);

        return dp[i][j];
    }
}