class Solution {
    Boolean[][] dp;
    boolean[][] pal;
    public boolean checkPartitioning(String s) {
        dp = new Boolean[s.length()][4];
        // NO.OF PALINDROMIC SUBSTRINGS QUESTION
        pal = new boolean[s.length()][s.length()];
        // fill base case
        for(int i=0;i<s.length();i++){
            pal[i][i] = true;
        }
        // bottom-up
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                pal[i][j] = (s.charAt(i) == s.charAt(j)) && ( (j-i+1) <= 3 || (pal[i+1][j-1]) );
            }
        }
        return solve(0, s, 0);
    }
    public boolean solve(int idx, String s, int cnt){
        if(idx == s.length()){
            return (cnt == 3) ? true : false;
        }
        if(cnt > 3)return false;

        if(dp[idx][cnt] != null){
            return dp[idx][cnt];
        }

        for(int k=idx;k<s.length();k++){
            if(isPalindrome(idx,k)){
                if(solve(k+1, s, cnt+1)){
                    dp[idx][cnt] = true;
                    return dp[idx][cnt];
                }
            }
        }

        dp[idx][cnt] = false;
        return dp[idx][cnt];
    }
    public boolean isPalindrome(int i, int j){
        return pal[i][j];
    }
}