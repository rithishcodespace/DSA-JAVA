// same as II, but with only 2 transactions allowed
// I took 1 transaction = 1(buy) + 1(sell), so base is checking 4

class Solution {
    public int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][5];
        return solve(0, 0, prices, dp, 0);
    }
    public int solve(int idx, int canIsell, int[] prices, Integer[][][] dp, int transactions){
        if(idx >= prices.length){
            return 0;
        }
        if(transactions > 4){
            return 0;
        }

        int wish = 0, not_wish = 0;

        if(dp[idx][canIsell][transactions] != null){
            return dp[idx][canIsell][transactions];
        }

        if(canIsell == 1){ // sell - gain
            wish = prices[idx] + solve(idx+1, 0, prices, dp, transactions+1);
            not_wish = 0 + solve(idx+1, 1, prices, dp, transactions);
        }
        else{ // buy - lost
            wish = -prices[idx] + solve(idx+1, 1, prices, dp, transactions+1);
            not_wish = 0 + solve(idx+1, 0, prices, dp, transactions);
        }

        dp[idx][canIsell][transactions] = Math.max(wish, not_wish);

        return dp[idx][canIsell][transactions];
    }
}