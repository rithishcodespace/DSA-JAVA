class Solution {
    boolean ans = false;
    public boolean containsCycle(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j] == 0){
                    dfs(grid,visited,i,j,i,j);
                }
            }
        }
        return ans;   
    }
    public void dfs(char[][] grid, int[][] visited, int row, int col, int prow, int pcol){
        visited[row][col] = 1;

        // up
        if(row-1 >= 0 && grid[row][col] == grid[row-1][col]){
            if(visited[row-1][col] == 0){
                dfs(grid,visited,row-1,col,row,col);
            }
            else if(!(row-1 == prow && col == pcol)){
                ans = true;
                return;
            }
        }
        // down
        if(row+1 < grid.length && grid[row][col] == grid[row+1][col]){
            if(visited[row+1][col] == 0){
                dfs(grid,visited,row+1,col,row,col);
            }
            else if(!(row+1 == prow && col == pcol)){
                ans = true;
                return;
            }
        }
        // left
        if(col-1 >= 0 && grid[row][col] == grid[row][col-1]){
            if(visited[row][col-1] == 0){
                dfs(grid,visited,row,col-1,row,col);
            }
            else if(!(row == prow && col-1 == pcol)){
                ans = true;
                return;
            }
        }
        // right
        if(col+1 < grid[0].length && grid[row][col] == grid[row][col+1]){
            if(visited[row][col+1] == 0){
                dfs(grid,visited,row,col+1,row,col);
            }
            else if(!(row == prow && col+1 == pcol)){
                ans = true;
                return;
            }
        }
    }
}