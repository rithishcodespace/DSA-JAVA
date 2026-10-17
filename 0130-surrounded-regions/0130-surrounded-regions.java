class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {

        // visit border regions with 'O'
        int[][] visited = new int[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            if(board[i][0] == 'O' && visited[i][0] == 0){ // 1'st col
                dfs(i, 0, visited, board);
            }
            if(board[i][board[0].length-1] == 'O' && visited[i][board[0].length-1] == 0){ // last col
                dfs(i, board[0].length-1, visited, board);
            }
        }

        for(int i=0;i<board[0].length;i++){
            if(board[0][i] == 'O' && visited[0][i] == 0){ // 1'st row
                dfs(0, i, visited, board);
            }
            if(board[board.length-1][i] == 'O' && visited[board.length-1][i] == 0){ // last row
                dfs(board.length-1, i, visited, board);
            }
        }

        // consume unvisited cells
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int r, int c, int[][] visited, char[][] board){
        visited[r][c] = 1;

        for(int[] d : dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && visited[nr][nc] == 0 && board[nr][nc] == 'O'){
                dfs(nr, nc, visited, board);
            }
        }
    }
}