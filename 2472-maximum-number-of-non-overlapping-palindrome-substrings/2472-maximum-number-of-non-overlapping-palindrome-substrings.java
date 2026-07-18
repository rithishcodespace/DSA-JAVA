// same as palindrome partition - return the max sized list inside the 2d ans list
// optimize by memoizing isPalindrome (cache true and false)

class Solution {
    boolean[][] palin_dp;
    int[] dp;

    public int maxPalindromes(String s, int k) {
        dp = new int[s.length()];
        palin_dp = new boolean[s.length()][s.length()];
        // precompute all palindromes
        int n = s.length();
        for(int i = n - 1;i >= 0;i--) { // O(n*n)
            for(int j = i;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j - i <= 2)
                        palin_dp[i][j] = true;
                    else
                        palin_dp[i][j] = palin_dp[i + 1][j - 1];
                }
            }
        }
        Arrays.fill(dp,-1);
        return solve(0, s, k);
    }

    public int solve(int idx, String s, int k){
        if(idx == s.length()){
            return 0;
        }

        if(dp[idx] != -1)return dp[idx];
     
        // not pick (i dont like to start palindrome building from here)
        int ans = Math.max(0, 0+solve(idx+1, s, k));

        // pick (i like to build palindrome from here)
        for(int i=idx+k-1;i<s.length();i++){
            if(palin_dp[idx][i]){
                ans = Math.max(ans, 1+solve(i+1, s, k));
                break; // small palidromes leaves space to create more in future
            }
        }

        return dp[idx] = ans;
    }

    public boolean isPalindrome(String str, int l, int r){

        while(l <= r){
            if(str.charAt(l++) != str.charAt(r--))return false;
        }

        return true;
    }
}