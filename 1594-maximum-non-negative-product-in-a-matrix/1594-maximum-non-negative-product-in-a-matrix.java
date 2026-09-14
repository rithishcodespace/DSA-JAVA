// we need to track 
// max product reaching this cell
// min product reaching this cell, since suddenly lowest value value can become largest when *'ed with negative

class Solution {
    public int maxProductPath(int[][] grid) {
        Pair[][] dp = new Pair[grid.length][grid[0].length];
        Pair ans = solve(0, 0, grid, dp);

        return (ans == null || ans.max < 0) ? -1 : (int)(ans.max%1000000007);
    }
    public Pair solve(int r, int c, int[][] grid, Pair[][] dp){
        // invalid case
        if(r >= grid.length || c >= grid[0].length){
            return null;
        }

        // base case
        if(r == grid.length-1 && c == grid[0].length-1){
            Pair p = new Pair(grid[r][c], grid[r][c]);
            return dp[r][c] = p;
        }

        // dp check
        if(dp[r][c] != null)return dp[r][c];

        // right
        Pair right = solve(r, c+1, grid, dp);

        // down
        Pair down = solve(r+1, c, grid, dp);

        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        long value = grid[r][c];

        if(right != null){
            min = Math.min(min, value * right.min);
            min = Math.min(min, value * right.max);

            max = Math.max(max, value * right.min);
            max = Math.max(max, value * right.max);
        }
        if(down != null){
            min = Math.min(min, value * down.min);
            min = Math.min(min, value * down.max);

            max = Math.max(max, value * down.min);
            max = Math.max(max, value * down.max);
        }

        Pair p = new Pair(min, max);
        return dp[r][c] = p;
    }
}
class Pair{
    long min, max;

    Pair(long min, long max){
        this.min = min;
        this.max = max;
    }
}