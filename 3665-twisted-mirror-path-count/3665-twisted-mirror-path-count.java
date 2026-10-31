// got into mirror from right -> go down
// got into mirror from up -> go right

// 0 -> right
// 1 -> down

class Solution {

    int[][][] dp;
    int MOD = 1000000007;

    public int uniquePaths(int[][] grid) {
        dp = new int[grid.length][grid[0].length][2];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, 0, grid);
    }

    public int solve(int r, int c, int direction, int[][] grid){
        // base case
        if(r == grid.length-1 && c == grid[0].length-1){
            return 1;
        }
        if(r >= grid.length || r < 0 || c < 0 || c >= grid[0].length){
            return 0;
        }

        if(dp[r][c][direction] != -1)return dp[r][c][direction];

        int right = 0, down = 0;

        if(grid[r][c] == 1){
            if (direction == 0) { // Entered mirror while moving right
                down = solve(r+1, c, 1, grid);
            }
            else{ // Entered mirror while moving down
                right = solve(r, c+1, 0, grid);
            }

        }
        else{
            // Normal cell: move right or down
            right = solve(r, c+1, 0, grid);
            down = solve(r+1, c, 1, grid);
        }

        return dp[r][c][direction] = (right+down)%MOD;
    }
}