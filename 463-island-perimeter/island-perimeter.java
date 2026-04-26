class Solution {
    int perimeter = 0;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int islandPerimeter(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    dfs(i,j,grid,visited);
                }
            }
        }

        return perimeter;
    }
    public void dfs(int r, int c, int[][] grid, int[][] visited){
        visited[r][c] = 1;
        perimeter += 4;

        for(int[] d : dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                if(grid[nr][nc] == 1){
                    perimeter--;
                    if(visited[nr][nc] == 0){
                        dfs(nr, nc, grid, visited);
                    }
                }

            }
        }
    }
}