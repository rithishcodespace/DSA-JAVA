class Solution {

    int MOD = 1_000_000_007;
    int[][] dp; // memoization + visited
    int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int countPaths(int[][] grid) {
        dp = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                solve(i, j, grid);
            }
        }

        long paths = 0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                paths += dp[i][j];
                paths = paths % MOD;
            }
        }

        return (int)paths;
    }

    public int solve(int r, int c, int[][] grid){
        if(dp[r][c] != 0){
            return dp[r][c];
        }

        int len = 0;

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                if(grid[nr][nc] > grid[r][c]){
                    len = (len + solve(nr, nc, grid)) % MOD;
                }
            }
        }

        dp[r][c] = (len + 1) % MOD;

        return dp[r][c];
    }
}