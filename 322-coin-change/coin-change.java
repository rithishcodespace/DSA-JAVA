class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];

        // fill base case - optional (since int[][] default is 0)

        for(int i=0;i<coins.length+1;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<amount+1;i++){
            dp[coins.length][i] = Integer.MAX_VALUE;
        }

        // try out all possibilities
        for(int idx = coins.length-1;idx>=0;idx--){
            for(int amnt = 0;amnt <= amount;amnt++){
                int pick = Integer.MAX_VALUE, not_pick = 0;

                if(coins[idx] <= amnt){
                    int res = dp[idx][amnt-coins[idx]];
                    pick = (res != Integer.MAX_VALUE) ? res + 1 : res;
                }

                not_pick = dp[idx+1][amnt];

                dp[idx][amnt] = Math.min(pick,not_pick);
            }
        }

        return (dp[0][amount] == Integer.MAX_VALUE) ? -1 : dp[0][amount];
    }
}