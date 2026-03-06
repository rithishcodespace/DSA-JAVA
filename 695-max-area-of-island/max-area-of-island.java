// bfs
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    max = Math.max(bfs(i,j,grid,visited),max);
                }
            }
        }
        return max;
    }
    public int bfs(int r, int c, int[][] grid, int[][] visited){
        int cnt = 1;
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(r,c));
        visited[r][c] = 1;

        while(!queue.isEmpty()){
            Element element = queue.poll();
            r = element.r;
            c = element.c;

            // up
            if(r-1 >= 0){
                if(grid[r-1][c] == 1 && visited[r-1][c] == 0){
                    visited[r-1][c] = 1;
                    queue.add(new Element(r-1,c));
                    cnt++;
                }
            }
            // down
            if(r+1 < grid.length && visited[r+1][c] == 0){
                if(grid[r+1][c] == 1){
                    visited[r+1][c] = 1;
                    queue.add(new Element(r+1,c));
                    cnt++;
                }
            }

            // left
            if(c-1 >= 0 && visited[r][c-1] == 0){
                if(grid[r][c-1] == 1){
                    visited[r][c-1] = 1;
                    queue.add(new Element(r,c-1));
                    cnt++;
                }
            }
            // right
            if(c+1 < grid[0].length && visited[r][c+1] == 0){
                if(grid[r][c+1] == 1){
                    visited[r][c+1] = 1;
                    queue.add(new Element(r,c+1));
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

class Element{
    int r;
    int c;

    Element(int r, int c){
        this.r = r;
        this.c = c;
    }
}