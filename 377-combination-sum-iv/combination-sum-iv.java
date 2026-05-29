class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target+1];
        return recursion(nums, target, dp);
    }
    public int recursion(int[] nums, int remaining, Integer[] dp){
        if(remaining == 0)return 1;
        if(remaining < 0)return 0;

        if(dp[remaining] != null)return dp[remaining];

        int ways = 0;

        for(int i=0;i<nums.length;i++){
            ways += recursion(nums, remaining-nums[i], dp);
        } 

        dp[remaining] = ways;

        return dp[remaining];
    }
}