class Solution {
    public int numSpecial(int[][] mat) {
       int cnt = 0;
       for(int i=0;i<mat.length;i++){
            int col = -1;
            boolean isOne = true;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1 && col == -1)col = j;
                else if(mat[i][j] == 1 && col != -1){
                    isOne = false;
                    break;
                }
            }
            if(isOne && col != -1){ // check the col
                for(int row=0;row<mat.length;row++){
                    if(mat[row][col] == 1 && row != i){
                        isOne = false;
                        break;
                    }
                }
                if(isOne)cnt++;
            }
       }
       return cnt; 
    }
}