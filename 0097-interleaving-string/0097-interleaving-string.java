// k -> idx3 (position on s3, to be created)
// call only if s1 or s2's index can match with s3's character

class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return solve(0, 0, s1, s2, s3);
    }

    public boolean solve(int idx1, int idx2, String s1, String s2, String s3){
        int k = idx1 + idx2;

        if(k >= s3.length()){
            return (idx1 >= s1.length() && idx2 >= s2.length()) ? true : false;
        }

        if(dp[idx1][idx2] != null)return dp[idx1][idx2];

        boolean pickFrom1 = false;
        if(idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(k)){
            pickFrom1 = solve(idx1+1, idx2, s1, s2, s3);
        }

        boolean pickFrom2 = false;
        if(idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(k)){
            pickFrom2 = solve(idx1, idx2+1, s1, s2, s3);
        }

        return dp[idx1][idx2] = pickFrom1 || pickFrom2;
    }
}