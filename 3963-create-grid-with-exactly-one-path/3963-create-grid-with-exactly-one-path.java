class Solution {
    public String[] createGrid(int m, int n) {
        char[][] matrix = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = '#';
            }
        }
        for(int j=0;j<n;j++){ // first row
            matrix[0][j] = '.';
        }
        for(int i=0;i<m;i++){ // last col
            matrix[i][n-1] = '.';;
        }
        int idx = 0;
        String[] ans = new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(matrix[i][j]);
            }
            ans[idx++] = sb.toString();
        }
        return ans;
    }
}