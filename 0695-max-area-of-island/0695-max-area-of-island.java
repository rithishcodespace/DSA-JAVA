class Solution {

    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j] == 0 && grid[i][j] > 0){
                    // start creating island
                    max = Math.max(max,dfs(i, j, grid, visited));
                }
            }
        }

        return max;
    }

    public int dfs(int r, int c, int[][] grid, int[][] visited){
        visited[r][c] = 1;
        int area = 0;
        
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] > 0 && visited[nr][nc] == 0){
                area += dfs(nr, nc, grid, visited);
            }
        }

        return grid[r][c] + area;
    } 
}