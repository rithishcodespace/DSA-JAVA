class Solution {

    Integer[] dp;

    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return solve(0, nums);
    }

    public int solve(int idx, int[] nums){
        if(idx >= nums.length)return 0;

        if(dp[idx] != null)return dp[idx];

        // pick
        int pick = nums[idx] + solve(idx+2, nums);
        // not pick
        int not_pick = 0 + solve(idx+1, nums);

        return dp[idx] = Math.max(pick, not_pick);
    }
}