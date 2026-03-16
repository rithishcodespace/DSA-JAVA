class Solution {
    int max = -1;
    public int maxDistance(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    bfs(grid,new Cell(i,j,0));
                }
            }
        }
        return max;
    }
    public void bfs(int[][] grid, Cell cell){
        int[][] visited = new int[grid.length][grid[0].length];

        Queue<Cell> queue = new LinkedList<>();
        queue.add(cell);
        visited[cell.r][cell.c] = 1;

        while(!queue.isEmpty()){
            Cell curr = queue.poll();

            // up
            if(curr.r-1 >= 0 && visited[curr.r-1][curr.c] == 0){
                if(grid[curr.r-1][curr.c] == 1){
                    max = Math.max(max,curr.dist+1);
                    return;
                }
                queue.add(new Cell(curr.r-1, curr.c, curr.dist+1));
                visited[curr.r-1][curr.c] = 1;
            }
            // down
            if(curr.r+1 < grid.length && visited[curr.r+1][curr.c] == 0){
                if(grid[curr.r+1][curr.c] == 1){
                    max = Math.max(max,curr.dist+1);
                    return;
                }
                queue.add(new Cell(curr.r+1, curr.c, curr.dist+1));
                visited[curr.r+1][curr.c] = 1;
            }
            // left
            if(curr.c-1 >= 0 && visited[curr.r][curr.c-1] == 0){
                if(grid[curr.r][curr.c-1] == 1){
                    max = Math.max(max,curr.dist+1);
                    return;
                }
                queue.add(new Cell(curr.r, curr.c-1, curr.dist+1));
                visited[curr.r][curr.c-1] = 1;
            }
            // right
            if(curr.c+1 < grid[0].length && visited[curr.r][curr.c+1] == 0){
                if(grid[curr.r][curr.c+1] == 1){
                    max = Math.max(max,curr.dist+1);
                    return;
                }
                queue.add(new Cell(curr.r, curr.c+1, curr.dist+1));
                visited[curr.r][curr.c+1] = 1;
            }
        }
    }
}

class Cell{
    int r;
    int c;
    int dist;

    Cell(int r, int c, int dist){
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}