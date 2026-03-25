class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long[][] rowPrefix1 = new long[grid.length][grid[0].length];
        long[][] rowPrefix2 = new long[grid.length][grid[0].length];
        long[][] colPrefix1 = new long[grid.length][grid[0].length];
        long[][] colPrefix2 = new long[grid.length][grid[0].length];

        // row prefix from top to bottom
        long rowSum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                rowSum += grid[i][j];
                rowPrefix1[i][j] = rowSum;
            }
        }

        // row prefix from bottom to top
        rowSum = 0;
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                rowSum += grid[i][j];
                rowPrefix2[i][j] = rowSum;
            }
        }

        // col prefix from top to bottom
        long colSum = 0;
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                colSum += grid[i][j];
                colPrefix1[i][j] = colSum;
            }
        }

        // col prefix from bottom to top
        colSum = 0;
        for(int j=grid[0].length-1;j>=0;j--){
            for(int i=grid.length-1;i>=0;i--){
                colSum += grid[i][j];
                colPrefix2[i][j] = colSum;
            }
        }

        // check for horizontal cut
        for(int i=0;i<grid.length;i++){
            long topFirst = rowPrefix1[i][grid[0].length-1];
            long bottomLast = (i+1 < grid.length) ? rowPrefix2[i+1][0] : -1;

            if(topFirst == bottomLast)return true;
        }

        // check for vertical cut
        for(int j=0;j<grid[0].length;j++){
            long bottomLast = colPrefix1[grid.length-1][j];
            long topFirst = (j+1 < grid[0].length) ? colPrefix2[0][j+1] : -1;

            if(topFirst == bottomLast)return true;
        }

        return false;
    }
}