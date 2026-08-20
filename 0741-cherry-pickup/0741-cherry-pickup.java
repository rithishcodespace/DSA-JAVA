// instead of doing 0 -> n then n -> 0
// send 2 persons from 0 -> n
// if both persons are at same index pick a singel cherry
// else pick both cherry

class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][][] dp = new Integer[grid.length+1][grid[0].length+1][grid.length+1][grid[0].length+1];
        int ans = solve(0, 0, 0, 0, grid, dp);
        return ans != Integer.MIN_VALUE ? ans : 0;
    }
    public int solve(int r1, int c1, int r2, int c2, int[][] grid, Integer[][][][] dp){
        // index validity
        if(r1 < 0 || r1 > grid.length-1 || r2 < 0 || r2 > grid.length-1){
            return Integer.MIN_VALUE;
        }
        if(c1 < 0 || c1 > grid[0].length-1 || c2 < 0 || c2 > grid[0].length-1){
            return Integer.MIN_VALUE;
        }
        if(grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }

        // base case
        if(r1 == grid.length-1 && c1 == grid[0].length-1 && r2 == grid.length-1 && c2 == grid[0].length-1){
            return grid[r1][c1] == 1 ? 1 : 0;
        }

        if(dp[r1][c1][r2][c2] != null)return dp[r1][c1][r2][c2];

        int cherries = Integer.MIN_VALUE;

        // right-right
        cherries = Math.max(cherries, solve(r1, c1+1, r2, c2+1, grid, dp));
        // right-bottom
        cherries = Math.max(cherries, solve(r1, c1+1, r2+1, c2, grid, dp));
        // bottom-bottom
        cherries = Math.max(cherries, solve(r1+1, c1, r2+1, c2, grid, dp));
        // bottom-right
        cherries = Math.max(cherries, solve(r1+1, c1, r2, c2+1, grid, dp));

        if(r1 == r2 && c1 == c2 && grid[r1][c1] == 1){ // pick one cherry
            if(cherries != Integer.MIN_VALUE)cherries += grid[r1][c1];
        }
        else{
            if(grid[r1][c1] == 1 && cherries != Integer.MIN_VALUE)cherries += grid[r1][c1];
            if(grid[r2][c2] == 1 && cherries != Integer.MIN_VALUE)cherries += grid[r2][c2];
        }

        return dp[r1][c1][r2][c2] = cherries;
    }
}