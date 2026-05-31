class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return f(0, 0, grid[0].length-1, grid, dp);
    }
    public int f(int i, int j1, int j2, int[][] grid, Integer[][][] dp){

        if(i >= grid.length || j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length){
            return (int)-1e9;
        }

        if(i == grid.length-1){
            if(j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }

        if(dp[i][j1][j2] != null)return dp[i][j1][j2];

        int max = (int)-1e9;

        // for each path of robot1, robot2 can take 3 paths
        for(int dj1 = -1;dj1<2;dj1++){ // j1 -> -1 to 1
            for(int dj2 = -1;dj2<2;dj2++){ // j2 -> -1 to 1

                int value = 0;

                // current value
                if(j1 == j2){
                    value = grid[i][j1];
                }
                else{
                    value = grid[i][j1] + grid[i][j2];
                }

                // values of lower level
                value += f(i+1, j1+dj1, j2+dj2, grid, dp);

                max = Math.max(max,value);
            }
        }

        dp[i][j1][j2] = max;

        return dp[i][j1][j2];
    }
}