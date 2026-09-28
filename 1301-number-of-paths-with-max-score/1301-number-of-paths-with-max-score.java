class Solution {
    int MOD = 1000000007;
    public int[] pathsWithMaxScore(List<String> board) {
        // convert the board into matrix
        char[][] matrix = new char[board.size()][board.get(0).length()];

        for(int i=0;i<board.size();i++){
            for(int j=0;j<board.get(i).length();j++){
                matrix[i][j] = board.get(i).charAt(j);
            }
        }

        int[][][] dp = new int[matrix.length][matrix[0].length][];

        int[] res = solve(matrix.length-1, matrix[0].length-1, dp, matrix);

        if(res[0] == Integer.MIN_VALUE)return new int[]{0,0};

        return res;
    }
    public int[] solve(int r, int c, int[][][] dp, char[][] matrix){
        if (r < 0 || c < 0 || matrix[r][c] == 'X') {
            return new int[]{Integer.MIN_VALUE, 0};
        }

        if (r == 0 && c == 0) {
            return new int[]{0, 1};
        }

        if(dp[r][c] != null)return dp[r][c];

        int curr = 0;

        if (matrix[r][c] >= '0' && matrix[r][c] <= '9') {
            curr = matrix[r][c] - '0';
        }

        // up
        int[] up = solve(r-1, c, dp, matrix);
        // up-left
        int[] up_left = solve(r-1, c-1, dp, matrix);
        // left
        int[] left = solve(r, c-1, dp, matrix);

        int max = Math.max(up[0], Math.max(up_left[0], left[0]));
        
        int count = 0;

        if(up[0] == max){
            count += up[1];
        }

        if(up_left[0] == max){
            count += up_left[1];
        }

        if(left[0] == max){
            count += left[1];
        }

        if(max == Integer.MIN_VALUE) {
            return dp[r][c] = new int[]{Integer.MIN_VALUE, 0};
        }

        return dp[r][c] = new int[]{(max+curr)%MOD, count%MOD};
    }
}