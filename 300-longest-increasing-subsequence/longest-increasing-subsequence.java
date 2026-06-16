// prevIdx => prevIdx+1 (to have -1 as prevIdx)
// use +1 only to access elements in dp table, not nums[]

class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        return solve(0, -1, nums, dp);
    }
    public int solve(int idx, int prevIdx, int[] nums, Integer[][] dp){
        if(idx >= nums.length){
            return 0;
        }

        if(dp[idx][prevIdx+1] != null){
            return dp[idx][prevIdx+1];
        }

        int pick = 0, not_pick = 0;

        // pick
        if(prevIdx == -1 || nums[prevIdx] < nums[idx]){
            pick = 1 + solve(idx+1, idx, nums, dp);
        }

        // not-pick
        not_pick = 0 + solve(idx+1, prevIdx, nums, dp);

        dp[idx][prevIdx+1] = Math.max(pick, not_pick);

        return dp[idx][prevIdx+1];
    }
}