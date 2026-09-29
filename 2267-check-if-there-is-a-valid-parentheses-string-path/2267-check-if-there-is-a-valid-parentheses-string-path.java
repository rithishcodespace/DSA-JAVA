class Solution {
    public boolean hasValidPath(char[][] grid) {
        Boolean[][][] dp = new Boolean[grid.length][grid[0].length][500];

        return solve(0, 0, 0, grid, dp);
    }
    public boolean solve(int r, int c, int stack, char[][] grid, Boolean[][][] dp){
        if(r >= grid.length || c >= grid[0].length){
            return false;
        }

        int curr = grid[r][c] == '(' ? 1 : -1;
        stack = stack + curr;
        
        if(r == grid.length-1 && c == grid[0].length-1){
            return stack == 0 ? true : false;
        }

        if(stack < 0)return false;

        if(dp[r][c][stack] != null)return dp[r][c][stack];

        // right
        boolean right = solve(r, c+1, stack, grid, dp);

        // down
        boolean down = solve(r+1, c, stack, grid, dp);

        return dp[r][c][stack] = right || down;
    }
}