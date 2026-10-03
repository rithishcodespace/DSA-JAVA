// same as peak element 1
// apply the same logic, but in terms of columns

// in the current col (mid), find the max num (so both up and down will be lesser)
// then check left and right, if not move l and r

// you make think, if we skip a col, the same col may contain peak elemnet in some other row (yah, there would be)
// since we need any peak, we skip the currnet col and move to next cols 

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low=0, high=mat[0].length-1;

        while(low<=high){
            int c = low+(high-low)/2; // mid will be the col
            int r = maxNumInCol(mat, c);

            int left = (c > 0) ? mat[r][c-1] : -1;
            int right = (c < mat[0].length-1) ? mat[r][c+1] : -1;

            if(mat[r][c] > left && mat[r][c] > right)return new int[]{r,c};
            else if(mat[r][c] < left)high=c-1;
            else low=c+1;
        }

        return new int[]{-1,-1};
    }
    public int maxNumInCol(int[][] mat, int c){
        int maxR = 0;

        for(int i=0;i<mat.length;i++){
            if(mat[maxR][c] < mat[i][c]){
                maxR = i;
            }
        }

        return maxR;
    }
}