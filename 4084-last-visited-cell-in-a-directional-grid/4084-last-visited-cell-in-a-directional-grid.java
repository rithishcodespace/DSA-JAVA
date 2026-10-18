class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int r=0, c=0;
        int[][] visited = new int[grid.length][grid[0].length];

        while(true){
            char dir = grid[r][c];
            int nr = 0, nc = 0;

            visited[r][c] = 1;

            if(dir == 'L'){
                nr = r; nc = c-1;
            }
            else if(dir == 'R'){
                nr = r; nc = c+1;
            }
            else if(dir == 'U'){
                nr = r-1; nc = c;
            }
            else{
                nr = r+1; nc = c;
            }

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc] == 0){
                r = nr;
                c = nc;
            }
            else{
                break;
            }
        }

        return new int[]{r, c};
    }
}