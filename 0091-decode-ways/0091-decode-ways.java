class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return solve(0, s, dp);
    }
    public int solve(int idx, String s, Integer[] dp){
        if(idx == s.length()){
            return 1;
        }
        else if(s.charAt(idx) == '0'){
            return 0; // leading zero
        }

        if(dp[idx] != null)return dp[idx];

        int num = 0, ways = 0;
        for(int i=idx;i<s.length();i++){
            num = num * 10 + (s.charAt(i)-'0');

            if(num >= 1 && num <= 26){
                ways += solve(i+1, s, dp);
            }
        }

        return dp[idx] = ways;
    }
}