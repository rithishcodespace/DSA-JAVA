// count only 1's in distance array
class Solution {
    public int minimumObstacles(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = grid[0][0];

        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a,b) -> a.d - b.d);
        minHeap.add(new Cell(0,0,grid[0][0]));

        while(!minHeap.isEmpty()){
            Cell cell = minHeap.poll();
            int r = cell.r;
            int c = cell.c;
            int d = cell.d;

            if(distance[r][c] < d)continue;

            // up
            if(r-1 >= 0){
                int new_d = d+grid[r-1][c];
                if(distance[r-1][c] > new_d){
                    distance[r-1][c] = new_d;
                    minHeap.add(new Cell(r-1,c,new_d));
                }
            }
            // down
            if(r+1 < grid.length){
                int new_d = d+grid[r+1][c];
                if(distance[r+1][c] > new_d){
                    distance[r+1][c] = new_d;
                    minHeap.add(new Cell(r+1,c,new_d));
                }
            }
            // left
            if(c-1 >= 0){
                int new_d = d+grid[r][c-1];
                if(distance[r][c-1] > new_d){
                    distance[r][c-1] = new_d;
                    minHeap.add(new Cell(r,c-1,new_d));
                }
            }
            // right
            if(c+1 < grid[0].length){
                int new_d = d+grid[r][c+1];
                if(distance[r][c+1] > new_d){
                    distance[r][c+1] = new_d;
                    minHeap.add(new Cell(r,c+1,new_d));
                }
            }
        }

        return distance[grid.length-1][grid[0].length-1];
    }
}
class Cell{
    int r;
    int c;
    int d;

    Cell(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}