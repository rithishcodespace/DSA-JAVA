// tabulation
// i = i-1 (to include -1 index)

class Solution {
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        // idx2 < 0 => matched entire t (valid)
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // idx1 < 0 && idx2 >= 0 (invalid)
        for(int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    int pick = dp[i - 1][j - 1];
                    int skip = dp[i - 1][j];

                    dp[i][j] = pick + skip;
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}