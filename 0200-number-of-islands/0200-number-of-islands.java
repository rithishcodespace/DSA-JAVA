class Solution {
    int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int islands=0;
        int[][] visited = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    islands++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return islands;
    }
    public void dfs(int r, int c, char[][] grid, int[][] visited){
        visited[r][c] = 1;

        for(int[] d : dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1' && visited[nr][nc] == 0){
                grid[nr][nc] = '1';
                dfs(nr, nc, grid, visited);
            }
        }
    }
}