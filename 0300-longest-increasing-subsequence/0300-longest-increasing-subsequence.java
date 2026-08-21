class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];
        return solve(0, -1, nums, dp);
    }
    public int solve(int idx, int prevIdx, int[] nums, Integer[][] dp){
        if(idx >= nums.length){
            return 0;
        }

        if(prevIdx != -1 && dp[idx][prevIdx] != null)return dp[idx][prevIdx];

        int pick = 0, not_pick = 0;

        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            pick = 1 + solve(idx+1, idx, nums, dp);
        }

        not_pick = solve(idx+1, prevIdx, nums, dp);

        if(prevIdx != -1)dp[idx][prevIdx] = Math.max(pick, not_pick);

        return Math.max(pick, not_pick);
    }
}