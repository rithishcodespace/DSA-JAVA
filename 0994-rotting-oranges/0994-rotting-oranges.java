// multi-source bfs

class Solution {
    public int orangesRotting(int[][] grid) {
        int minute = 0, fresh = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();

        // initially rotten oranges
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
                else if(grid[i][j] == 1)fresh++;
            }
        }

        if(fresh == 0)return 0;

        // rot other ones too
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc] == 0 && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        visited[nr][nc] = 1;
                        fresh--;

                        q.add(new int[]{nr, nc});
                    }
                }
            }
            minute++;
        }

        return (fresh == 0) ? minute-1 : -1; // reduce last level, when no new oranges rott
    }
}