class Solution {
    
    int MOD = 1000000007;
    int[][] dir = {
        {4,6}, // 0
        {8,6}, // 1
        {7,9}, // 2
        {4,8}, // 3
        {0,3,9}, // 4
        {}, // 5
        {0,1,7}, // 6
        {2,6}, // 7
        {1,3}, // 8
        {2,4} // 9
    };

    public int knightDialer(int n) {
        int seq = 0;
        Integer[][] dp = new Integer[10][n];

        for(int i=0;i<10;i++){
            seq = (seq + solve(i, n-1, dp)) % MOD;
        }

        return seq;
    }

    public int solve(int cell, int n, Integer[][] dp){
        if(n==0){
            return 1;
        }

        if(dp[cell][n] != null)return dp[cell][n];

        int seq = 0;
        for(int c : dir[cell]){
            seq = (seq + solve(c, n-1, dp)) % MOD;
        }

        return dp[cell][n] = seq;
    }
}