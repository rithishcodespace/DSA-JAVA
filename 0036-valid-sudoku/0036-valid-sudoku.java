class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    if(!isvalid(i, j, board))return false;
                }
            }
        }
        return true;
    }
    public boolean isvalid(int r, int c, char[][] board){
        // check whether the current number repeated again in row and column
        for(int i=0;i<9;i++){
            if(i != c && board[r][i] == board[r][c])return false;
            if(i != r && board[i][c] == board[r][c])return false;
        }

        // check the 3*3 cell
        int nr = (r/3)*3;
        int nc = (c/3)*3;

        int[] freq = new int[10];

        for(int i=nr;i<nr+3;i++){
            for(int j=nc;j<nc+3;j++){
                if(board[i][j] != '.'){
                    freq[board[i][j]-'0']++;
                    if(freq[board[i][j]-'0'] > 1)return false;
                }
            }
        }

        return true;
    }
}