// if msb is 0, move (rows)
// if zeros > ones, move (cols)

class Solution {
    public int matrixScore(int[][] grid) {
        int sum = 0;

        // flip row
        for(int i=0;i<grid.length;i++){
            if(grid[i][0] == 0){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j] == 0){ 
                        grid[i][j] = 1;
                    }
                    else grid[i][j] = 0;
                }
            }
        }

        // flip cols
        for(int c=grid[0].length-1;c>=0;c--){
            int zeros = 0, ones = 0;
            for(int r=0;r<grid.length;r++){
                if(grid[r][c] == 0){
                    zeros++;
                }
                else ones++;
            }
            if(zeros > ones){
                for(int r=0;r<grid.length;r++){
                    if(grid[r][c] == 0){
                        grid[r][c] = 1;
                    }
                    else grid[r][c] = 0;
                }
            }
        }

        // convert to decimal (each row)
        for(int i=0;i<grid.length;i++){
            int num = 0, p=0;
            for(int j=grid[0].length-1;j>=0;j--){
                if(grid[i][j] == 1)num += (1 << p);
                p++;
            }
            sum += num;
        }

        return sum;
    }
}