// just sell again after 2 days

class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return solve(0, 0, prices, dp);
    }
    public int solve(int idx, int canIsell, int[] prices, Integer[][] dp){
        if(idx >= prices.length){
            return 0;
        }

        if(dp[idx][canIsell] != null)return dp[idx][canIsell];

        int wish = 0, not_wish = 0;

        if(canIsell == 1){ // sell
            wish = prices[idx] + solve(idx+2, 0, prices, dp);
            not_wish = solve(idx+1, 1, prices, dp);
        }
        else{ // buy
            wish = -prices[idx] + solve(idx+1, 1, prices, dp);
            not_wish = solve(idx+1, 0, prices, dp);
        }

        return dp[idx][canIsell] = Math.max(wish, not_wish);
    }
}