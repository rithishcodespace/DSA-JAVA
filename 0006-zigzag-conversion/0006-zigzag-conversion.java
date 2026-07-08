class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)return s;
        int idx = 0, col = 0;
        char[][] grid = new char[numRows][s.length()];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(grid[i],'0');
        }
        while(idx < s.length()){
            // fill left col
            for(int i=0;i<numRows;i++){
                if (idx == s.length()) break;
                grid[i][col] = s.charAt(idx++);
            }
            // next center col
            for(int i=numRows-2;i>=1;i--){
                col++;
                if (idx == s.length()) break;
                grid[i][col] = s.charAt(idx++);
            }
            col++; // for next row
        }    

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] != '0')sb.append(grid[i][j]);
            }
        }   

        return sb.toString();
    }
}