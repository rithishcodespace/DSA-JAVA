// Minimum health required before entering (r,c) to survive from there to the princess.

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        Integer[][] dp = new Integer[dungeon.length+1][dungeon[0].length+1];
        return solve(0, 0, dungeon, dp);
    }
    public int solve(int r, int c, int[][] dungeon, Integer[][] dp){
        // invalid index
        if(r >= dungeon.length || r < 0 || c >= dungeon[0].length || c < 0){
            return Integer.MAX_VALUE;
        }

        // base case
        if(r == dungeon.length-1 && c == dungeon[0].length-1){
            return Math.max(1, 1-dungeon[r][c]);
        }

        if(dp[r][c] != null)return dp[r][c];

        // right
        int right = solve(r, c+1, dungeon, dp);

        // down
        int down = solve(r+1, c, dungeon, dp);

        // min path
        int next = Math.min(right, down);

        return dp[r][c] = Math.max(1, next - dungeon[r][c]);
    }
}