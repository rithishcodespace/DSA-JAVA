// mutli-source bfs

class Solution {
    public int orangesRotting(int[][] grid) {
        int minute = -1, fresh = 0;

        int[][] dir = {{-1,0}, {1,0}, {0, -1}, {0,1}};

        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Cell> queue = new LinkedList<>();

        // insert all rotten oranges
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1)fresh++;
                if(grid[i][j] == 2){
                    queue.add(new Cell(i, j));
                }
            }
        }

        if(fresh == 0)return 0;

        // BFS
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                Cell c = queue.poll();

                for(int[] d : dir){
                    int nr = c.r + d[0];
                    int nc = c.c + d[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc] == 0 && grid[nr][nc] == 1){
                        queue.add(new Cell(nr, nc));
                        visited[nr][nc] = 1;
                        fresh--;
                    }
                }
            }

            minute++;
        }

        return fresh == 0 ? minute : -1;
    }
}
class Cell{
    int r, c;
    Cell(int r, int c){
        this.r = r;
        this.c = c;
    }
}