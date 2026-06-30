// DFS

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    int[][] visited = new int[board.length][board[0].length];
                    visited[i][j] = 1;
                    if(dfs(i, j, 1, word, board, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int row, int col, int idx, String word, char[][] board, int[][] visited){

        if(idx == word.length())return true;

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] dir : directions){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && visited[nr][nc] == 0 && board[nr][nc] == word.charAt(idx)){
                visited[nr][nc] = 1;
                if(dfs(nr, nc, idx+1, word, board, visited)){
                    return true;
                }
                // backtrack
                visited[nr][nc] = 0;
            }
        }

        return false;
    }
}