class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int max = 0;
        int[][] transformed_matrix = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int above = (i>0) ? transformed_matrix[i-1][j] : 0;
                int below = matrix[i][j];

                transformed_matrix[i][j] = (below != 0) ? above+below : 0;

            }
            max = Math.max(findMatrix(transformed_matrix[i]), max);
        }

        return max;
    }
    public int findMatrix(int[] matrix){
        int[] arr = matrix.clone();
        Arrays.sort(arr);
        
        int max = 0;

        for(int i=0;i<matrix.length;i++){
            int width = i+1;

            max = Math.max(max, width * arr[arr.length - i - 1]);
        }

        return max;
    }
}