class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return solve(0, 0, word1, word2, dp);   
    }
    public int solve(int idx1, int idx2, String word1, String word2, Integer[][] dp){
        if(idx1 == word1.length()){
            return word2.length() - idx2;
        }

        if(idx2 == word2.length()){
            return word1.length() - idx1;
        }

        if(dp[idx1][idx2] != null)return dp[idx1][idx2];

        char ch1 = word1.charAt(idx1);
        char ch2 = word2.charAt(idx2);

        int insert = 0, update = 0, delete = 0;

        if(ch1 == ch2){
            return dp[idx1][idx2] = solve(idx1+1, idx2+1, word1, word2, dp);
        }
        else{
            // insert
            insert += solve(idx1, idx2+1, word1, word2, dp) + 1;
            // delete
            delete += solve(idx1+1, idx2, word1, word2, dp) + 1;
            // update
            update += solve(idx1+1, idx2+1, word1, word2, dp) + 1;
        }

        return dp[idx1][idx2] = Math.min(insert, Math.min(delete, update));
    }
}