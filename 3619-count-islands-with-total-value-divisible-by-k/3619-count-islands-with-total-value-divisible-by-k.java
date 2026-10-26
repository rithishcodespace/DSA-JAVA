// flood fill

class Solution {

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public int countIslands(int[][] grid, int k) {
        int count=0;
        int[][] visited = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j] == 0 && grid[i][j] != 0){
                    long sum = dfs(i, j, visited, grid);
                    count += (sum%k == 0) ? 1 : 0;
                }
            }
        }

        return count;
    }
    public long dfs(int r, int c, int[][] visited, int[][] grid){
        visited[r][c] = 1;

        long sum=grid[r][c];

        for(int[] d :  dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc] == 0 && grid[nr][nc] != 0){
                sum += dfs(nr, nc, visited, grid);
            }
        }

        return sum;
    }
}