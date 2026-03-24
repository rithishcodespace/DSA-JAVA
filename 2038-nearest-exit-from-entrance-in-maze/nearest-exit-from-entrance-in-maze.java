class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        // mark border cells
        for(int i=0;i<maze[0].length;i++){
            if(maze[0][i] == '.'){ // 1'st row
                maze[0][i] = 'b';
            }
            if(maze[maze.length-1][i] == '.'){ // last row
                maze[maze.length-1][i] = 'b';
            }
        }
        for(int i=0;i<maze.length;i++){
            if(maze[i][0] == '.'){ // 1'st col
                maze[i][0] = 'b';
            }
            if(maze[i][maze[0].length-1] == '.'){
                maze[i][maze[0].length-1] = 'b';
            }
        }
        maze[entrance[0]][entrance[1]] = '.';
        // bfs from the start cell
        return bfs(maze,entrance);
    }
    public int bfs(char[][] maze, int[] entrance){ // normal bfs - without heap
        int[][] distance = new int[maze.length][maze[0].length];
       for(int i = 0; i < maze.length; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(entrance[0],entrance[1],0));
        distance[entrance[0]][entrance[1]] = 0;

        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            int r = cell.r;
            int c = cell.c;
            int d = cell.d;

            if(distance[r][c] < d)continue;

            // up
            if(r-1 >= 0){
                if(maze[r-1][c] == '.' && d+1 < distance[r-1][c]){
                    distance[r-1][c] = d+1;
                    queue.add(new Cell(r-1,c,d+1));
                }
                else if(maze[r-1][c] == 'b'){
                    return d+1;
                }
            }
            // down
            if(r+1 < maze.length){
                if(maze[r+1][c] == '.' && d+1 < distance[r+1][c]){
                    distance[r+1][c] = d+1;
                    queue.add(new Cell(r+1,c,d+1));
                }
                else if(maze[r+1][c] == 'b'){
                    return d+1;
                }
            }
            // left
            if(c-1 >= 0){
                if(maze[r][c-1] == '.' && d+1 < distance[r][c-1]){
                    distance[r][c-1] = d+1;
                    queue.add(new Cell(r,c-1,d+1));
                }
                else if(maze[r][c-1] == 'b'){
                    return d+1;
                }
            }
            // right
            if(c+1 < maze[0].length){
                if(maze[r][c+1] == '.' && d+1 < distance[r][c+1]){
                    distance[r][c+1] = d+1;
                    queue.add(new Cell(r,c+1,d+1));
                }
                else if(maze[r][c+1] == 'b'){
                    return d+1;
                }
            }
        }
        return -1;
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