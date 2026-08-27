class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans);

        return ans;
    }
    public void solve(int col, char[][] board, List<List<String>> ans){
        // base case
        if(col == board.length){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder row = new StringBuilder();
                for(int j=0;j<board[0].length;j++){
                    row.append(board[i][j]);
                }
                temp.add(row.toString());
            }
            ans.add(temp);
            return;
        }

        // try to place a queen in the current col
        for(int i=0;i<board.length;i++){
            if(isSafe(i, col, board)){
                board[i][col] = 'Q';
                solve(col+1, board, ans);
                board[i][col] = '.'; // backtrack
            }
        }
    }
    public boolean isSafe(int r, int c, char[][] board){
        // top-left
        for(int i=r, j=c;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // left
        for(int i=c;i>=0;i--){
            if(board[r][i] == 'Q'){
                return false;
            }
        }
        // bottom-left
        for(int i=r, j=c;i<board.length && j>=0;i++, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // top-right, bottom-right, right need not to be check since we place queens from left to right
        // top and bottom need not to be checked since we place one queen per row

        return true;
    }
}