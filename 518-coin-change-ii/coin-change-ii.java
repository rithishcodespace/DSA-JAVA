class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        // fill base case
        for(int idx = 0;idx <= coins.length;idx++){
            dp[idx][0] = 1;
        }

        // optinal since int[][] fills 0
        for(int amt = 1;amt <= amount;amt++){
            dp[coins.length][amt] = 0;
        }

        // try out all possibilities
        for(int idx = coins.length-1;idx >= 0;idx--){
            for(int amt = 0;amt <= amount;amt++){
                int pick = 0, not_pick = 0;

                if(coins[idx] <= amt){
                    pick = dp[idx][amt-coins[idx]];
                }

                not_pick = dp[idx+1][amt];

                dp[idx][amt] = pick+not_pick;
            }
        }

        return dp[0][amount];
    }
}