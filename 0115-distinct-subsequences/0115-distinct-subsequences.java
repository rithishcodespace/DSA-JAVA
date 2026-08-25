class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()][t.length()];
        return solve(s.length()-1, t.length()-1, s, t, dp);
    }
    public int solve(int idx1, int idx2, String s, String t, Integer[][] dp){
        if(idx2 < 0){ // entire t is consumed
            return 1;
        }
        if(idx1 < 0){ // entire s is consumed
            return 0;
        }

        if(dp[idx1][idx2] != null)return dp[idx1][idx2];

        char ch1 = s.charAt(idx1);
        char ch2 = t.charAt(idx2);

        int pick = 0, not_pick = 0;

        if(ch1 == ch2){
            pick = solve(idx1-1, idx2-1, s, t, dp); // pick this match and move on
            not_pick = solve(idx1-1, idx2, s, t, dp); // try for another match
        }
        else{
            not_pick = solve(idx1-1, idx2, s, t, dp);
        }

        return dp[idx1][idx2] = pick + not_pick;
    }
}