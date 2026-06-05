class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length+1][amount+1];
        int cnt = solve(0, amount, coins, dp);
        return (cnt == Integer.MAX_VALUE) ? -1 : cnt;
    }
    public int solve(int idx, int amount, int[] coins, Integer[][] dp){
        if(idx >= coins.length || amount <= 0){
            return (amount == 0) ? 0 : Integer.MAX_VALUE;
        }

        if(dp[idx][amount] != null){
            return dp[idx][amount];
        }

        int pick = Integer.MAX_VALUE, not_pick = 0;

        if(coins[idx] <= amount){
            int res = solve(idx, amount-coins[idx], coins, dp);
            pick = (res != Integer.MAX_VALUE) ? res+1 : res;
        }

        not_pick = solve(idx+1, amount, coins, dp);

        dp[idx][amount] = Math.min(pick,not_pick);

        return dp[idx][amount];
    }
}