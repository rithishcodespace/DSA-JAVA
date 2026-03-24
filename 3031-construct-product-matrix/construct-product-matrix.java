class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int[][] prefix = new int[grid.length][grid[0].length];
        int[][] suffix = new int[grid.length][grid[0].length];
        int[][] matrix = new int[grid.length][grid[0].length];

        int prev = 1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int curr = grid[i][j];
                prefix[i][j] = prev;
                prev = (int)(((long)curr * prev) % 12345);
            }
        }

        prev = 1;
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                int curr = grid[i][j];
                suffix[i][j] = prev;
                prev = (int)(((long)curr * prev) % 12345);
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                matrix[i][j] = (prefix[i][j]*suffix[i][j]) % 12345;
            }
        }

        return matrix;
    }
}