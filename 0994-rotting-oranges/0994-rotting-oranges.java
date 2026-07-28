// multi-source bfs

class Solution {
    public int orangesRotting(int[][] grid) {
        int min = -1, fresh = 0;
        int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        Queue<Cell> queue = new LinkedList<>();

        // insert the rotten oranges at 0'th min
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.add(new Cell(i, j));
                }
                else if(grid[i][j] == 1)fresh++;
            }
        }

        if(fresh == 0)return 0;

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                Cell cell = queue.poll();

                for(int[] d : dir){
                    int nr = cell.r + d[0];
                    int nc = cell.c + d[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                        if(grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            fresh--;
                            queue.add(new Cell(nr, nc));
                        }
                    }
                }
            }
            min++;
        }

        return (fresh == 0) ? min : -1;
    }
}

class Cell{
    int r, c;

    Cell(int r, int c){
        this.r = r;
        this.c = c;
    }
}