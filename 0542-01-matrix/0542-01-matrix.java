// multi-source bfs

class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length]; // visited + ans
        int[][] visited = new int[mat.length][mat[0].length];

        // insert all destination cells (0)
        Queue<Cell> queue = new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    queue.add(new Cell(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        // multi_source_bfs

        while(!queue.isEmpty()){
            Cell cell = queue.poll();

            int r = cell.r;
            int c = cell.c;
            int dist = cell.d;

            if(mat[r][c] == 1){
                distance[r][c] = dist;
            }

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length){
                    if(visited[nr][nc] == 0){
                        queue.add(new Cell(nr, nc, dist+1));
                        visited[nr][nc] = 1;
                    }
                }
            }
        }

        return distance;
    }
}

class Cell{
    int r, c, d;

    Cell(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}