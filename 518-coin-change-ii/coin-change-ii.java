class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length+1][amount+1];
        return solve(0, amount, coins, dp);
    }
    public int solve(int idx, int amount, int[] coins, Integer[][] dp){
        if(idx >= coins.length || amount <= 0){
            return (amount == 0) ? 1 : 0;
        }

        if(dp[idx][amount] != null){
            return dp[idx][amount];
        }

        int pick = 0, not_pick = 0;

        if(coins[idx] <= amount){
            pick = solve(idx, amount-coins[idx], coins, dp);
        }

        not_pick = solve(idx+1, amount, coins, dp);

        dp[idx][amount] = pick + not_pick;

        return dp[idx][amount];
    }
}