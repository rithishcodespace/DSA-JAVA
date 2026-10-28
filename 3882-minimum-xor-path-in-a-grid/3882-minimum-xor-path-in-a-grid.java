// dfs 
// dp is just to skip overlapping problems

class Solution {
    int ans = Integer.MAX_VALUE;
    boolean[][][] dp;
    public int minCost(int[][] grid) {
        dp = new boolean[grid.length][grid[0].length][1024]; // 1024 -> max possible xor
        dfs(0, 0, grid[0][0], grid);
        return ans;
    }
    public void dfs(int r, int c, int xor, int[][] grid){
        // if already visited this state
        if(dp[r][c][xor]){
            return;
        }

        // save this state
        dp[r][c][xor] = true;

        // base condition
        if(r == grid.length-1 && c == grid[0].length-1){
            ans = Math.min(ans, xor);
            return;
        }

        // right
        if(c+1 < grid[0].length){
            dfs(r, c+1, xor^grid[r][c+1], grid);
        }
        // down
        if(r+1 < grid.length){
            dfs(r+1, c, xor^grid[r+1][c], grid);
        }
    }
}