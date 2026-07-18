// Time Complexity  : O(m × n × 3^L)
// Space Complexity : O(m × n + L)

class Solution {
    int[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, 1, word, board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int r, int c, int idx, String word, char[][] board){
        if(idx == word.length())return true;

        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length){
                if(board[nr][nc] == word.charAt(idx) && visited[nr][nc] == 0){
                    visited[r][c] = 1;
                    if(dfs(nr, nc, idx+1, word, board)){
                        visited[r][c] = 0; // backtrack
                        return true;
                    }
                    visited[r][c] = 0; // backtrack
                }
            }
        }

        return false;
    }
}