// case1 - entire island
// case2 - single cell

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        int[][] visited = new int[grid2.length][grid2[0].length];
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j] == 1 && visited[i][j] == 0 && grid1[i][j] == 1){
                    if(dfs(grid1,grid2,visited,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean dfs(int[][] grid1, int[][] grid2, int[][] visited, int r, int c){
        visited[r][c] = 1;
        boolean isValid = true;

        if(grid1[r][c] == 0){
            isValid = false;
        }

        // up
        if(r-1 >= 0 && grid2[r-1][c] == 1 && visited[r-1][c] == 0){
            visited[r-1][c] = 1;
            isValid = dfs(grid1, grid2, visited, r-1, c) && isValid;
        }
        // down
        if(r+1 < grid1.length && grid2[r+1][c] == 1 && visited[r+1][c] == 0){
            visited[r+1][c] = 1;
            isValid = dfs(grid1, grid2, visited, r+1, c) && isValid;
        }
        // left
        if(c-1 >= 0 && grid2[r][c-1] == 1 && visited[r][c-1] == 0){
            visited[r][c-1] = 1;
            isValid = dfs(grid1, grid2, visited, r, c-1) && isValid;
        }
        // right
        if(c+1 < grid1[0].length && grid2[r][c+1] == 1 && visited[r][c+1] == 0){
            visited[r][c+1] = 1;
            isValid = dfs(grid1, grid2, visited, r, c+1) && isValid;
        }

        return isValid;
    }
}