class Solution {
    public int countSquares(int[][] matrix) {
        int squares = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }
                else if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
                // sum each cell
                squares += dp[i][j];
            }
        }

        return squares;
    }
}