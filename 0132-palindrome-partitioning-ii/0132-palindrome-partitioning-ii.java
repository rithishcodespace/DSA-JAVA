// front partition

class Solution {
    Integer[] dp;
    public int minCut(String s) {
        dp = new Integer[s.length()];
        return solve(0, s);
    }
    public int solve(int idx, String s){
        if(idx == s.length()){
            return -1; // no.of partitions = no.of palindromes-1;
        }

        if(dp[idx] != null){
            return dp[idx];
        }

        int min = s.length()-1;

        for(int i=idx;i<s.length();i++){
            if(isPalindrome(idx,i,s)){
                int partitions = 1 + solve(i+1, s);
                min = Math.min(min,partitions);
            }
        }

        dp[idx] = min;

        return dp[idx];
    }
    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}