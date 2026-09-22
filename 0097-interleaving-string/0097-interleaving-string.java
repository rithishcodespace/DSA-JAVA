// build the s3, by checking either idx1 or idx2 matches the currently searching idx3 (k)

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return solve(0, 0, s1, s2, s3, dp);
    }
    public boolean solve(int idx1, int idx2, String s1, String s2, String s3, Boolean[][] dp){
        int k = idx1+idx2; // idx3

        if(dp[idx1][idx2] != null)return dp[idx1][idx2];

        if(idx1 == s1.length() && idx2 == s2.length()){
            return true;
        }

        boolean res = false;

        if(idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(k)){
            res = res || solve(idx1+1, idx2, s1, s2, s3, dp);
        }
        if(idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(k)){
            res = res || solve(idx1, idx2+1, s1, s2, s3, dp);
        }


        return dp[idx1][idx2] = res;
    }
}