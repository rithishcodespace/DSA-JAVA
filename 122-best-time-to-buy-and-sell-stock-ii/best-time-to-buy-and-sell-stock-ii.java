class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];

        // fill base case
        dp[prices.length][0] = dp[prices.length][1] = 0;

        // explore all possiblities
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int wish = 0, not_wish = 0;

                if(j == 1){ // sell - gain
                    wish = prices[i] + dp[i+1][0];
                    not_wish = 0 + dp[i+1][1];
                }
                else{ // buy - lost
                    wish = -prices[i] + dp[i+1][1];
                    not_wish = 0 + dp[i+1][0];
                }

                dp[i][j] = Math.max(wish, not_wish);
            }
        }

        return dp[0][0];
    }
}