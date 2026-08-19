class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount+1];
        int len = solve(amount, coins, dp);
        return len != Integer.MAX_VALUE ? len : -1; 
    }
    public int solve(int amount, int[] coins, Integer[] dp){
        if(amount == 0){
            return 0;
        }

        if(dp[amount] != null)return dp[amount];

        int minLen = Integer.MAX_VALUE;

        for(int c : coins){
            if(amount-c >= 0){
                int len = solve(amount-c, coins, dp);
                if(len != Integer.MAX_VALUE){
                    minLen = Math.min(minLen, 1 + len);
                }
            }
        }

        return dp[amount] = minLen;
    }
}