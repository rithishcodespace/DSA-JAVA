// Top left cell in each 3*3 box:
// start_row = (r/3)*3, start_col = (c/3)*3

// Since board is always 9*9
// tc: O(1)
// sc: O(1)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // find cells that is not empty (.)
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    if(!isValid(i, j, board[i][j], board)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public boolean isValid(int row, int col, char num, char[][] board){
        // check both of it's row and col 
        for(int i=0;i<9;i++){
            // col
            if(board[row][i] == num && i != col)return false;
            // row
            if(board[i][col] == num && i != row)return false;
        }

        // find top left cell of cell 3*3 box
        int s_r = (row/3)*3;
        int s_c = (col/3)*3;

        int[] freq = new int[10];

        for(int i=s_r;i<s_r+3;i++){
            for(int j=s_c;j<s_c+3;j++){
                if(board[i][j] != '.'){
                    freq[board[i][j]-'0']++;
                    if(freq[board[i][j]-'0'] > 1)return false;
                }
            }
        }

        return true;
    }
}