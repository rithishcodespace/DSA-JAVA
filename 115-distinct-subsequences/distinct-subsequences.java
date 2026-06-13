// question: find no.of subsequences of s, matches t (full string)
// MEMOIZATION
// O(m*n)
// dp[m][n] ~ 8MB 

class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()][t.length()];
        return solve(s.length()-1, t.length()-1, s, t, dp);
    }
    public int solve(int idx1, int idx2, String s, String t, Integer[][] dp){
        if(idx2 < 0){
            return 1;
        }
        if(idx1 < 0){
            return 0;
        }

        if(dp[idx1][idx2] != null)return dp[idx1][idx2];

        int pick = 0, skip = 0;

        if(s.charAt(idx1) == t.charAt(idx2)){
            pick = solve(idx1-1, idx2-1, s, t, dp);
            skip = solve(idx1-1, idx2, s, t, dp);
        }
        else{
            skip = solve(idx1-1, idx2, s, t, dp);
        }

        dp[idx1][idx2] = pick+skip;

        return dp[idx1][idx2];
    }
}