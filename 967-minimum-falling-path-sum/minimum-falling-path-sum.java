class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            dp[matrix.length-1][i] = matrix[matrix.length-1][i];
        }

        for(int i=matrix.length-2;i>=0;i--){
            for(int j=matrix.length-1;j>=0;j--){
                int left = 0, down = 0, right = 0;

                if(i+1 < matrix.length && j-1 >= 0){
                    left = dp[i+1][j-1] + matrix[i][j];
                }
                else left = (int)1e9;

                if(i+1 < matrix.length){
                    down = dp[i+1][j] + matrix[i][j];
                }
                else down = (int)1e9;

                if(i+1 < matrix.length && j+1 < matrix[0].length){
                    right = dp[i+1][j+1] + matrix[i][j];
                }
                else right = (int)1e9;

                dp[i][j] = Math.min(left,Math.min(down,right));
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<matrix[0].length;i++){
            min = Math.min(min, dp[0][i]);
        }

        return min;
    }
}