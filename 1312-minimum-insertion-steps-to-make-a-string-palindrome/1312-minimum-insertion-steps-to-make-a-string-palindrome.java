// ans = str.length - lps

class Solution {
    public int minInsertions(String s) {
        return s.length() - lps(s);
    }
    public int lps(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return lcs(0, s, 0, new StringBuilder(s).reverse().toString(), dp);
    }
    public int lcs(int idx1, String text1, int idx2, String text2, Integer[][] dp){
        if(idx1 >= text1.length() || idx2 >= text2.length()){
            return 0;
        }

        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }

        int match = 0, not_match1 = 0, not_match2 = 0;

        // match
        if(text1.charAt(idx1) == text2.charAt(idx2)){
            match = 1 + lcs(idx1+1, text1, idx2+1, text2, dp);
        }
        else{ // not match
            not_match1 = 0 + lcs(idx1+1, text1, idx2, text2, dp);
            not_match2 = lcs(idx1, text1, idx2+1, text2, dp);
        }

        dp[idx1][idx2] = (match + Math.max(not_match1, not_match2));

        return dp[idx1][idx2];
    }
}