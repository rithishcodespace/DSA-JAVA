class Solution {
    public String longestPalindrome(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        return findLCS(s1, s2);
    }

    public String findLCS(String s1, String s2) {
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];

        int maxLen = 0;
        int endIndex = 0; // end index of palindrome in original string

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // position in original string
                    int origIndexInS = n - j; 

                    // Only update if the substring aligns correctly to form a palindrome
                    // i-1 -> ending index in s1
                    // n - j -> starting index in s1
                    // check => originalIndex + len of substring === starting index
                    if (dp[i][j] > maxLen && origIndexInS + dp[i][j] - 1 == i - 1) {
                        maxLen = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        if (maxLen == 0) return s1.substring(0, 1); // single character fallback

        return s1.substring(endIndex - maxLen + 1, endIndex + 1);
    }
}