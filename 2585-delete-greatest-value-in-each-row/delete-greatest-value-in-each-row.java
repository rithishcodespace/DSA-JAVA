class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            sortRow(grid[i]);
        }
        return ans(grid);
    }
    public void sortRow(int[] row){
        for(int i=0;i<row.length-1;i++){
            for(int j=0;j<row.length-i-1;j++){
                if(row[j+1] < row[j]){
                    int temp = row[j];
                    row[j] = row[j+1];
                    row[j+1] = temp;
                }
            }
        }
    }
    public int ans(int[][] grid){
        int ans = 0;
        for(int j=0;j<grid[0].length;j++){
            int max = grid[0][j];
            for(int i=0;i<grid.length;i++){
                max = Math.max(max,grid[i][j]);
            }
            ans += max;
        }
        return ans;
    }
}