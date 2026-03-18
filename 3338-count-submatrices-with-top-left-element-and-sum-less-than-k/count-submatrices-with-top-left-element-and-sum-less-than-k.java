class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;

        // add top element + left element repeatedly
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int curr = grid[i][j];
                int top = (i-1 >= 0) ? grid[i-1][j] : 0;
                int left = (j-1 >= 0) ? grid[i][j-1] : 0;
                int topLeft = (i-1 >= 0 && j-1 >= 0) ? grid[i-1][j-1] : 0;

                curr = curr+left+top-topLeft;
                if(curr <= k)count++;

                grid[i][j] = curr;
            }
        }

        return count;
    }
}