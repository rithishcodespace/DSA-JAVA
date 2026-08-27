// isSafe - O(1)

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        HashSet<Integer> upper_diag = new HashSet<>();
        HashSet<Integer> lower_diag = new HashSet<>();
        HashSet<Integer> row = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans, upper_diag, lower_diag, row);

        return ans;
    }
    public void solve(int col, char[][] board, List<List<String>> ans, HashSet<Integer> upper_diag, HashSet<Integer> lower_diag, HashSet<Integer> row){
        // base case
        if(col == board.length){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++){
                    sb.append(board[i][j]);
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        // try to place a queen in the current col
        for(int i=0;i<board.length;i++){
            if(isSafe(i, col, board, upper_diag, lower_diag, row)){
                // consume
                board[i][col] = 'Q';
                upper_diag.add(i-col);
                lower_diag.add(i+col);
                row.add(i);
                solve(col+1, board, ans, upper_diag, lower_diag, row);
                // backtrack
                board[i][col] = '.'; 
                upper_diag.remove(i-col);
                lower_diag.remove(i+col);
                row.remove(i);
            }
        }
    }
    public boolean isSafe(int r, int c, char[][] board, HashSet<Integer> upper_diag, HashSet<Integer> lower_diag, HashSet<Integer> row){
        // top-left
        if(upper_diag.contains(r-c))return false;
        // left
        if(lower_diag.contains(r+c))return false;
        // bottom-left
        if(row.contains(r))return false;

        // top-right, bottom-right, right need not to be check since we place queens from left to right
        // top and bottom need not to be checked since we place one queen per row

        return true;
    }
}