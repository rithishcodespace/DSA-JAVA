// striver video
// - s has ?,*
// - p has chars, so order changed (only changes in main() parameter passing order)

class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[p.length()][s.length()];
        return solve(p.length()-1, s.length()-1, p, s, dp);
    }
    public boolean solve(int idx1, int idx2, String s, String p, Boolean[][] dp){
        // base case
        if(idx1 < 0 && idx2 < 0)return true;
        if(idx2 < 0 && idx1 >= 0){
            for(int i=idx1;i>=0;i--){
                if(s.charAt(i) != '*')return false;
            }
            return true;
        }
        if(idx1 < 0)return false;

        if(dp[idx1][idx2] != null)return dp[idx1][idx2];

        // recurrence
        if(s.charAt(idx1) == '*'){
            boolean not_pick = solve(idx1-1, idx2, s, p, dp);
            boolean pick = solve(idx1, idx2-1, s, p, dp);

            dp[idx1][idx2] = pick || not_pick;

            return dp[idx1][idx2];
        }
        else if(s.charAt(idx1) == p.charAt(idx2) || s.charAt(idx1) == '?'){
            dp[idx1][idx2] = solve(idx1-1, idx2-1, s, p, dp);
            return dp[idx1][idx2];   
        }
        
        dp[idx1][idx2] = false;

        return false; // if(idx1 != idx2)
    }
}