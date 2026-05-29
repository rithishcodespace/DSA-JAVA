class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        
        // base case
        for(int i=0;i<dp[0].length;i++){
            dp[dp.length-1][i] = triangle.get(dp.length-1).get(i);
        }

        // bottom-up
        for(int i=dp.length-2;i>=0;i--){
            for(int j=triangle.get(i).size()-1;j>=0;j--){
                int bottom = 0, diagonal = 0;

                bottom = dp[i+1][j];

                if(j+1 < dp[0].length){
                    diagonal = dp[i+1][j+1];
                }

                dp[i][j] = Math.min(bottom,diagonal) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}