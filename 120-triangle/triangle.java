class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return recursion(0, 0, triangle, dp);
    }
    public int recursion(int i, int j, List<List<Integer>> triangle, int[][] dp){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != Integer.MAX_VALUE)return dp[i][j];

        int down = triangle.get(i).get(j) + recursion(i+1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + recursion(i+1, j+1, triangle, dp);

        dp[i][j] = Math.min(down, diagonal);

        return dp[i][j];
    }
}