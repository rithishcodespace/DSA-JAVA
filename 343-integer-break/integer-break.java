class Solution {
    int[] dp;
    public int integerBreak(int n) {
        int max = 0;
        dp = new int[n];
        Arrays.fill(dp,-1);
        for(int i=1;i<n;i++){
            int res = Math.max(max,i*solve(n-i));
            max = Math.max(max,res);
        }
        return max;
    }

    public int solve(int n){
        // System.out.println(n);
        if(n <= 0){
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int max = 1;
        for(int i=1;i<=n;i++){
            int res = i*solve(n-i);
            // System.out.println(n + " " + res + " " + i + " " + (n - i));
            max = Math.max(max,res);
        }
        dp[n] = max;
        return max;
    }
}