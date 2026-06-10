// str.length - lcs;

class Solution {
    public int minInsertions(String s) {
        int lcs = longestCommonSubsequence(s,new StringBuilder(s).reverse().toString());
        return s.length()-lcs;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return solve(text1.length()-1, text2.length()-1, text1, text2, dp);
    }
    public int solve(int idx1, int idx2, String text1, String text2, Integer[][] dp){
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }

        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }

        int match = 0, not_match1 = 0, not_match2 = 0;

        // match
        if(text1.charAt(idx1) == text2.charAt(idx2)){
            match = 1 + solve(idx1-1, idx2-1, text1, text2, dp);
        }
        else{ // not match
            not_match1 = 0 + solve(idx1-1, idx2, text1, text2, dp);
            not_match2 = solve(idx1, idx2-1, text1, text2, dp);
        }

        dp[idx1][idx2] = (match + Math.max(not_match1, not_match2));

        return dp[idx1][idx2];
    }
}