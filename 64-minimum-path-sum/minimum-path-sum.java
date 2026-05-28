class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        // base case
        dp[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];

        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i == grid.length-1 && j == grid[0].length-1){
                    continue;
                }

                int down = (int)1e9, right = (int)1e9;

                if(i+1 < grid.length){
                    down = dp[i+1][j];
                }

                if(j+1 < grid[0].length){
                    right = dp[i][j+1];
                }

                dp[i][j] = grid[i][j] + Math.min(down,right);
            }
        }

        return dp[0][0];
    }
}