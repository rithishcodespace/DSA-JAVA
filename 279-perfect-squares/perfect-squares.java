class Solution {
    public int numSquares(int n) {
        Integer[] dp = new Integer[n+1];
        return solve(n,dp);
    }
    public int solve(int n, Integer[] dp){
        if(n <= 0){
            return (n == 0) ? 0 : Integer.MAX_VALUE;
        }

        if(dp[n] != null){
            return dp[n];
        }

        int min = Integer.MAX_VALUE;
        for(int i=1;i*i <= n;i++){
            int res = 1+solve(n-(i*i),dp);
            min = Math.min(res,min);
        }

        dp[n] = min;

        return dp[n];
    }
}