class Solution {
    public int minFallingPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length+1][grid[0].length+1];
        return solve(0, -1, grid, dp);
    }
    public int solve(int r, int pc, int[][] grid, Integer[][] dp){
        if(r >= grid.length){
            return 0;
        }

        if(pc != -1 && dp[r][pc] != null)return dp[r][pc];

        int minSum = Integer.MAX_VALUE;

        // pickevery col
        for(int i=0;i<grid[0].length;i++){
            if(i != pc){
                minSum = Math.min(minSum, grid[r][i] + solve(r+1, i, grid, dp));
            }
        }

        if(pc != -1)dp[r][pc] = minSum;

        return minSum;
    }
}