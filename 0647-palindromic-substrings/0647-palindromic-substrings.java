// tabulation
// dp[i][j] = (i == j) && does (i-1 == j-1) <- calculated by tabulation

class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        // base case
        for(int i=0;i<s.length();i++){
            dp[i][i] = true;
        }

        // try all possibilities
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && ( ((j-i+1) <=3) || dp[i+1][j-1] );
                if(dp[i][j]){
                    cnt++;
                }
            }
        }

        return (cnt == 0) ? 1 : cnt;
    }
}