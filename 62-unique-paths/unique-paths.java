class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(m,n,0,0,dp);
    }
    public int f(int m, int n, int i, int j, int[][] dp){
        if(i == m-1 && j == n-1){
            return 1; // 1 valid path found
        }
        if(i >= m || j >= n){
            return 0; // out of bound
        }

        if(dp[i][j] != -1)return dp[i][j];

        int down = f(m,n,i+1,j, dp);
        int right = f(m,n,i,j+1, dp);

        dp[i][j] = down+right;

        return dp[i][j];
    }
}