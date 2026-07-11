class Solution {
    int paths = 0;
    int nonOstacles = 0;
    public int uniquePathsIII(int[][] grid) {
        int startRow = 0, startCol = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        // find the start point
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                }

                if(grid[i][j] != -1)nonOstacles++;
            }
        }

        visited[startRow][startCol] = 1;
        solve(startRow, startCol, 1, visited, grid);

        return paths;
    }
    public void solve(int r, int c, int cellsCovered, int[][] visited, int[][] grid){
        if(grid[r][c] == 2){
            if(cellsCovered == nonOstacles)paths++;
            return;
        }

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] d : dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc] == 0){
                if(grid[nr][nc] == 0 || grid[nr][nc] == 2){
                    visited[nr][nc] = 1;
                    solve(nr, nc, cellsCovered+1, visited, grid);
                    // backtrack
                    visited[nr][nc] = 0;
                }
            }
        }
    }
}