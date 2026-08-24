class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return solve(0, text1, 0, text2, dp);   
    }
    public int solve(int idx1, String text1, int idx2, String text2, Integer[][] dp){
        if(idx1 >= text1.length() || idx2 >= text2.length()){
            return 0;
        }

        if(dp[idx1][idx2] != null)return dp[idx1][idx2];

        char ch1 = text1.charAt(idx1);
        char ch2 = text2.charAt(idx2);

        return dp[idx1][idx2] = (ch1 == ch2) ? 1+solve(idx1+1, text1, idx2+1, text2, dp) :  Math.max(solve(idx1, text1, idx2+1, text2, dp), solve(idx1+1, text1, idx2, text2, dp));
    }
}