class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 0){
            dp[obstacleGrid.length-1][obstacleGrid[0].length-1] = 1;
        }
        else return 0;

        for(int i=obstacleGrid.length-1;i>=0;i--){
            for(int j=obstacleGrid[0].length-1;j>=0;j--){
                if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1){
                    continue;
                }

                if(obstacleGrid[i][j] == 1)continue;

                int bottom = 0, right = 0;

                if(i+1 < obstacleGrid.length){
                    bottom = dp[i+1][j];
                }

                if(j+1 < obstacleGrid[0].length){
                    right = dp[i][j+1];
                }

                dp[i][j] = bottom+right;
            }
        }

        return dp[0][0];
    }
}