class Solution {
    public int orangesRotting(int[][] grid) {
        int minute = -1, fresh = 0;

        Queue<Cell> queue = new LinkedList<>();
        Integer[][] visited = new Integer[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.add(new Cell(i, j));
                    visited[i][j] = 1;
                }
                else if(grid[i][j] == 1)fresh++;
            }
        }
        
        if(fresh == 0)return 0;

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int n = queue.size();

            for(int i=0;i<n;i++){
                Cell c = queue.poll();

                for(int[] d : dir){
                    int nr = d[0] + c.r;
                    int nc = d[1] + c.c;

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc] == null && grid[nr][nc] == 1){
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