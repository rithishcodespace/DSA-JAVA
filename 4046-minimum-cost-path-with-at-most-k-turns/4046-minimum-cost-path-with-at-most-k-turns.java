// dijkstra

// 0 -> up
// 1 -> down
// 2 -> left
// 3 -> right

class Solution {
    public int minCost(int[][] grid, int k) {
        if(grid.length == 1 && grid[0].length == 1)return grid[0][0];

        int[][][][] dist = new int[grid.length][grid[0].length][4][k+1];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int d = 0; d < 4; d++) {
                    Arrays.fill(dist[i][j][d], Integer.MAX_VALUE);
                }
            }
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> {
           return a.distance-b.distance;
        });

        pq.add(new Cell(0, 0, grid[0][0], -1, 0));

        while(!pq.isEmpty()){
            Cell cell = pq.poll();
            int r = cell.r, c = cell.c, distance = cell.distance, nr = -1, nc = -1, direction = cell.direction, turns = cell.turns;

            // prune larger turns
            if(turns > k)continue;

            // omit outdated distance
            if(direction != -1 && distance > dist[r][c][direction][turns]){
                continue;
            }

            // up
            nr = r-1; nc = c;
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                int newDistance = distance + grid[nr][nc];

                if(direction == 0 || direction == -1){
                    if(newDistance < dist[nr][nc][0][turns]){
                        dist[nr][nc][0][turns] = newDistance;
                        pq.add(new Cell(nr, nc, newDistance, 0, turns));
                    }
                }
                else{
                    if(turns + 1 <= k && newDistance < dist[nr][nc][0][turns+1]){
                        dist[nr][nc][0][turns+1] = newDistance;
                        pq.add(new Cell(nr, nc, newDistance, 0, turns+1));
                    }
                }
            }
            // down
            nr = r+1; nc = c;
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                int newDistance = distance + grid[nr][nc];

                if(direction == 1 || direction == -1){
                    if(newDistance < dist[nr][nc][1][turns]){
                        dist[nr][nc][1][turns] = newDistance;
                        pq.add(new Cell(nr, nc, newDistance, 1, turns));
                    }
                }
                else{
                    if(turns + 1 <= k && newDistance < dist[nr][nc][1][turns+1]){
                        dist[nr][nc][1][turns+1] = newDistance;
                        pq.add(new Cell(nr, nc, newDistance, 1, turns+1));
                    }
                }
            }
            // left
            nr = r; nc = c-1;
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                int newDistance = distance + grid[nr][nc];

                if(direction == 2 || direction == -1){
                    if(newDistance < dist[nr][nc][2][turns]){
                        dist[nr][nc][2][turns] = newDistance;
                        pq.add(new Cell(nr, nc, newDistance, 2, turns));
                    }
                }
                else{
                    if(turns + 1 <= k && newDistance < dist[nr][nc][2][turns+1]){
                        dist[nr][nc][2][turns+1] = newDistance;
                        pq.add(new Cell(nr, nc, newDistance, 2, turns+1));
                    }
                }
            }
            // right
            nr = r; nc = c+1;
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                int newDistance = distance + grid[nr][nc];

                if(direction == 3 || direction == -1){
                    if(newDistance < dist[nr][nc][3][turns]){
                        dist[nr][nc][3][turns] = newDistance;
                        pq.add(new Cell(nr, nc, newDistance, 3, turns));
                    }
                }
                else{
                    if(turns + 1 <= k && newDistance < dist[nr][nc][3][turns+1]){
                        dist[nr][nc][3][turns+1] = newDistance;
                        pq.add(new Cell(nr, nc, newDistance, 3, turns+1));
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE, lr = grid.length-1, lc = grid[0].length-1;

        for(int d=0; d<4; d++){
            for(int t=0; t<=k; t++){
                ans = Math.min(ans, dist[lr][lc][d][t]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
class Cell{
    int r, c, distance, direction, turns;

    Cell(int r, int c, int distance, int direction, int turns){
        this.r = r;
        this.c = c;
        this.distance = distance;
        this.direction = direction;
        this.turns = turns;
    }
}