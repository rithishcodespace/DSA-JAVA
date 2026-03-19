class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int count = 0;
        Pair[][] prefixSum = new Pair[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                prefixSum[i][j] = new Pair(0, 0);
            }
        }
    
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int xleft = 0, yleft = 0;
                int xtop = 0, ytop = 0;

                if(i-1 >= 0){
                    xtop = prefixSum[i-1][j].x;
                    ytop = prefixSum[i-1][j].y;
                }

                if(j-1 >= 0){
                    xleft = prefixSum[i][j-1].x;
                    yleft = prefixSum[i][j-1].y;
                }

                if(grid[i][j] == 'X'){
                    prefixSum[i][j].x++;
                }
                else if(grid[i][j] == 'Y'){
                    prefixSum[i][j].y++;
                }

                int xtopLeft = (i-1 >= 0 && j-1 >= 0) ? prefixSum[i-1][j-1].x : 0;
                int ytopLeft = (i-1 >= 0 && j-1 >= 0) ? prefixSum[i-1][j-1].y : 0;

                prefixSum[i][j].x = prefixSum[i][j].x + xtop + xleft - xtopLeft;
                prefixSum[i][j].y = prefixSum[i][j].y + ytop + yleft - ytopLeft;

                if(prefixSum[i][j].x == prefixSum[i][j].y && prefixSum[i][j].x > 0)count++;
            }
        }
        return count;
    }
}

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}