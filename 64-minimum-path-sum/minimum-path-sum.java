class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,grid,dp);
    }
    public int f(int r, int c, int[][] grid, int[][] dp){
        if(r == grid.length-1 && c == grid[0].length-1){
            return grid[r][c];
        }
        if(r >= grid.length || c >= grid[0].length){
            return (int)1e9;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int down = grid[r][c] + f(r+1,c,grid,dp);
        int right = grid[r][c] + f(r,c+1,grid,dp);

        dp[r][c] = Math.min(down,right);

        return dp[r][c];
    }
}