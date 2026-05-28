class Solution {

    public int minDistance(String word1, String word2){
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return recursion(word1, word2, 0, 0, dp);
    }

    public int recursion(String word1, String word2, int i, int j, int[][] dp){

        // word1 exhausted
        if(i == word1.length()) {
            return word2.length() - j;
        }

        // word2 exhausted
        if(j == word2.length()) {
            return word1.length() - i;
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            return recursion(word1, word2, i+1, j+1, dp);
        }

        if(dp[i][j] != -1)return dp[i][j];

        // insert
        int insert = 1 + recursion(word1, word2, i, j+1, dp);

        // delete
        int delete = 1 + recursion(word1, word2, i+1, j, dp);

        // replace
        int replace = 1 + recursion(word1, word2, i+1, j+1, dp);

        dp[i][j] = Math.min(insert,Math.min(delete, replace));

        return dp[i][j];
    }
}