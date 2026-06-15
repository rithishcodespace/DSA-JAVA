// same as II,III,IV
// we need to -fee from the total profit for each transaction
// like counting transactions, do -fee

class Solution {
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        Integer[][] dp = new Integer[prices.length][2];
        return solve(0, 0, prices, dp);
    }
    public int solve(int idx, int canIsell, int[] prices, Integer[][] dp){
        if(idx >= prices.length){
            return 0;
        }

        int wish = 0, not_wish = 0;

        if(dp[idx][canIsell] != null){
            return dp[idx][canIsell];
        }

        if(canIsell == 1){ // sell - gain
            wish = prices[idx] + solve(idx+1, 0, prices, dp) + (-fee);
            not_wish = 0 + solve(idx+1, 1, prices, dp);
        }
        else{ // buy - lost
            wish = -prices[idx] + solve(idx+1, 1, prices, dp);
            not_wish = 0 + solve(idx+1, 0, prices, dp);
        }

        dp[idx][canIsell] = Math.max(wish, not_wish);

        return dp[idx][canIsell];
    }
}