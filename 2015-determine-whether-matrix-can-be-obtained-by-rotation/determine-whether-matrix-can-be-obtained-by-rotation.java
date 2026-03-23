class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // 1'st rotation
        int[][] mat1 = rotate(mat);
        if(compare(target,mat1))return true;
        // 2'nd rotation
        int[][] mat2 = rotate(mat1);
        if(compare(target,mat2))return true;
        // 3'rd rotation
        int[][] mat3 = rotate(mat2);
        if(compare(target,mat3))return true;
        // 2'nd rotation
        int[][] mat4 = rotate(mat3);
        if(compare(target,mat4))return true;
        
        return false;
    }

    public int[][] rotate(int[][] matrix){
        int[][] mat = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                mat[j][i] = matrix[i][j];
            }
        }
        for(int i=0;i<mat.length;i++){
            
            int[] row = mat[i];
            int l=0,r=mat[i].length-1;
            while(l < r){
                int temp = row[l];
                row[l] = row[r];
                row[r] = temp;
                l++;r--;
            }
            
        }

        return mat;
    }

    public boolean compare(int[][] matrix1, int[][] matrix2){
        for(int i=0;i<matrix1.length;i++){
            for(int j=0;j<matrix1.length;j++){
                if(matrix1[i][j] != matrix2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}