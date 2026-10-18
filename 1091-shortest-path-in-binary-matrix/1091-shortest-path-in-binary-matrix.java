// bfs

class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,-1},{-1,1},{1,-1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Cell> q = new LinkedList<>();

        if(grid[0][0] == 1)return -1;
        if(grid[0][0] == 0 && grid.length == 1 && grid[0].length == 1)return 1;

        q.add(new Cell(0, 0, 1));
        visited[0][0] = 1;

        while(!q.isEmpty()){
            Cell cell = q.poll();
            int r = cell.r, c = cell.c, distance = cell.dist;

            for(int[] d : dir){
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc] == 0 && grid[nr][nc] == 0){
                    if(nr == grid.length-1 && nc == grid[0].length-1)return distance+1;
                    q.add(new Cell(nr, nc, distance+1));
                    visited[nr][nc] = 1;
                }
            }
        }

        return -1;
    }
}
class Cell{
    int r, c, dist;

    Cell(int r, int c, int dist){
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}