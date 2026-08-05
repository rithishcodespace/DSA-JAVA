class Solution {
    Long[] dp;
    public long rob(int[] nums, int[] colors) {
        dp = new Long[nums.length];
        return solve(0, nums, colors);
    }
    public long solve(int idx, int[] nums, int[] colors){
        if(idx >= nums.length){
            return 0;
        }

        if(dp[idx] != null)return dp[idx];

        // pick
        long pick = 0;
        if(idx+1 < nums.length && colors[idx] != colors[idx+1]){
            pick = nums[idx] + solve(idx+1, nums, colors);
        }
        else pick = nums[idx] + solve(idx+2, nums, colors);

        // not pick
        long notPick = 0 + solve(idx+1, nums, colors);

        return dp[idx] = Math.max(pick, notPick);
    }
}