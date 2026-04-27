class Solution{

    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean hasValidPath(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        return dfs(0,0,grid,visited);
    }

    public boolean dfs(int r, int c, int[][] grid, int[][] visited){
        if(visited[r][c] == 1)return false;
        visited[r][c] = 1;

        if(r == grid.length-1 && c == grid[0].length-1){
            return true;
        }

        int n = grid[0].length;
        int m = grid.length;

        if(grid[r][c] == 1){ // left, right
    
            // left
            int nr = r, nc = c - 1;
            if(nc >= 0 && canConnect(grid[nr][nc], 'L')){
                if(dfs(nr, nc, grid, visited))return true;
            }

            // right
            nr = r; nc = c + 1;
            if(nc < n && canConnect(grid[nr][nc], 'R')){
                if(dfs(nr, nc, grid, visited))return true;
            }

        }
        else if(grid[r][c] == 2){ // up, down
            
            // up
            int nr = r - 1, nc = c;
            if(nr >= 0 && canConnect(grid[nr][nc], 'U')){
                if(dfs(nr, nc, grid, visited))return true;
            }

            // down
            nr = r + 1; nc = c;
            if(nr < m && canConnect(grid[nr][nc], 'D')){
                if(dfs(nr, nc, grid, visited))return true;
            }
        }
        else if(grid[r][c] == 3){ // left, down

            // left
            int nr = r, nc = c - 1;
            if(nc >= 0 && canConnect(grid[nr][nc], 'L')){
                if(dfs(nr, nc, grid, visited))return true;
            }

            // down
            nr = r + 1; nc = c;
            if(nr < m && canConnect(grid[nr][nc], 'D')){
                if(dfs(nr, nc, grid, visited))return true;
            }
        }
        else if(grid[r][c] == 4){ // right, down

            // right
            int nr = r, nc = c + 1;
            if(nc < n && canConnect(grid[nr][nc], 'R')){
                if(dfs(nr, nc, grid, visited))return true;
            }

            // down
            nr = r + 1; nc = c;
            if(nr < m && canConnect(grid[nr][nc], 'D')){
                if(dfs(nr, nc, grid, visited))return true;
            }
        }
        else if(grid[r][c] == 5){ // left, up

            // left
            int nr = r, nc = c - 1;
            if(nc >= 0 && canConnect(grid[nr][nc], 'L')){
                if(dfs(nr, nc, grid, visited))return true;
            }

            // up
            nr = r - 1; nc = c;
            if(nr >= 0 && canConnect(grid[nr][nc], 'U')){
               if(dfs(nr, nc, grid, visited))return true;
            }
        }
        else{ // 6 → right, up

            // right
            int nr = r, nc = c + 1;
            if(nc < n && canConnect(grid[nr][nc], 'R')){
                if(dfs(nr, nc, grid, visited))return true;
            }

            // up
            nr = r - 1; nc = c;
            if(nr >= 0 && canConnect(grid[nr][nc], 'U')){
                if(dfs(nr, nc, grid, visited))return true;
            }
        }

        return false;
    } 

    public boolean canConnect(int num, char from){

        // reverse direction
        if(from == 'L') from = 'R';
        else if(from == 'R') from = 'L';
        else if(from == 'U') from = 'D';
        else if(from == 'D') from = 'U';

        if(num == 1 ){ // left, right
            if(from == 'L' || from == 'R')return true;
        }
        else if(num == 2){ // up, down
            if(from == 'U' || from == 'D')return true;
        }
        else if(num == 3){ // left, down
            if(from == 'L' || from == 'D')return true;
        }
        else if(num == 4){ // right, down
            if(from == 'R' || from == 'D')return true;
        }
        else if(num == 5){ // left, up
            if(from == 'L' || from == 'U')return true;
        }
        else{ // right, up
            if(from == 'R' || from == 'U')return true;
        }

        return false;
    }
}