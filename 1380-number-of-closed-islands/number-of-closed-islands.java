class Solution {

    int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};

    public int closedIsland(int[][] grid) {

        int cnt = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        // mark the islands, collect their start node
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j] == 0 && grid[i][j] == 0){
                    boolean[] result = {true};
                    dfs(i, j, visited, grid, result);
                    if(result[0]){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    // if the node is in border, return false
    public void dfs(int r, int c, int[][] visited, int[][] grid, boolean[] result){
        visited[r][c] = 1;

        if(r == 0 || r == grid.length-1 || c == 0 || c == grid[0].length-1){
            result[0] = false;
        }
        
        for(int[] d : dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc] == 0 && grid[nr][nc] == 0){
                dfs(nr, nc, visited, grid, result);
            }
        }
    }
}