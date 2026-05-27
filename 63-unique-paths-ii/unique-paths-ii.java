class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,obstacleGrid,dp);
    }
    public int f(int r, int c, int[][] grid, int[][] dp){
        if(r == grid.length-1 && c == grid[0].length-1){
            if(grid[r][c] == 1)return 0;
            else return 1;
        }
        if(r >= grid.length || c >= grid[0].length){
            return 0;
        }
        if(grid[r][c] == 1){
            return 0;
        }

        if(dp[r][c] != -1)return dp[r][c];

        int bottom = f(r+1,c,grid, dp);
        int right = f(r,c+1,grid, dp);

        dp[r][c] = bottom+right;

        return dp[r][c];
    }
}