// approach 1 -> find row with (start >= target <= end)
// approach 2 -> l = 0, r = no.of cells-1
// r = mid/col, c = mid%col

// tc: O(log(m+n))
// sc: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0, r=(matrix.length * matrix[0].length)-1, cols=matrix[0].length;
        while(l <= r){
            int mid = l+(r-l)/2;
            int row = mid/cols, col=mid%cols;

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }

        return false;
    }
}