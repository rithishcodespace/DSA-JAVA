// DFS from each cell (as source) + memoization

class Solution {
    Integer[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int maxPath = 0;
        dp = new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int path = solve(i, j, matrix);
                maxPath = Math.max(maxPath,path);
            }
        }

        return maxPath;
    }
    public int solve(int r, int c, int[][] matrix){
        if(dp[r][c] != null)return dp[r][c];

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        int pathLen = 0;

        for(int[] dir : directions){
            int nr = r+dir[0];
            int nc = c+dir[1];

            if(nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && matrix[r][c] < matrix[nr][nc]){
                pathLen = Math.max(solve(nr, nc, matrix), pathLen);
            }
        }

        dp[r][c] = pathLen+1;

        return dp[r][c];
    }
}