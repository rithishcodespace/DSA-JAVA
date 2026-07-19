// every recursive problem moves row downward
// every safe places moves col forward

// Time Complexity:
// There are at most N choices for each of the N columns.
// In the worst case, the recursion explores O(N!) valid placements.
// For each placement, isSafe() checks at most 3 directions, each taking O(N).
// Therefore, overall time complexity is O(N × N!).

// Space Complexity:
// O(N^2) for the chess board.
// O(N) recursion stack (maximum one recursive call per column).
// Excluding the output, auxiliary space is O(N^2).
// Including the recursion stack: O(N^2 + N) = O(N^2).

class Solution {

    List<List<String>> ans = new ArrayList<>();
    String[][] board;

    public List<List<String>> solveNQueens(int n) {
        // build the chess board
        board = new String[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],".");
        }
        // recursion
        solve(0);
        return ans;
    }

    public void solve(int col){
        // base case 
        if(col == board.length){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder row = new StringBuilder();
                for(int j=0;j<board.length;j++){
                    row.append(board[i][j]);
                }
                temp.add(row.toString());
            }
            ans.add(temp);
            return;
        }

        // visit all rows of the current col
        for(int i=0;i<board.length;i++){
            if(isSafe(i, col)){
                board[i][col] = "Q";
                solve(col+1);
                // backtrack
                board[i][col] = ".";
            }
        }
    }

    public boolean isSafe(int r, int c){
        // top-left
        for(int i=r,j=c; i>=0 && j>=0; i--,j--){
            if(board[i][j].equals("Q"))return false;
        }
        // left
        for(int i=c;i>=0;i--){
            if(board[r][i].equals("Q"))return false;
        }
        // bottom-left
        for(int i=r,j=c ;i<board.length && j>=0 ;i++,j--){
            if(board[i][j].equals("Q"))return false;
        }
        // bottom-right, right - not needed, since we placing queen from left -> right (it will hanlde it via left dir)

        return true;
    }
}