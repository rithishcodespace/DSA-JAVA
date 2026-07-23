class Solution {
    Integer[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[strs.length][m+1][n+1];
        return solve(0, m, n, strs);       
    }
    public int solve(int idx, int zeros, int ones, String[] strs){
        if(idx == strs.length){
            return 0;
        }

        if(dp[idx][zeros][ones] != null)return dp[idx][zeros][ones];

        // not pick
        int len1 = solve(idx+1, zeros, ones, strs);

        // pick
        // count zeros and ones
        int zero = 0, one = 0;
        for(int i=0;i<strs[idx].length();i++){
            if(strs[idx].charAt(i) == '0'){
                zero++;
            }
            else{
                one++;
            }
        }
        
        int len2 = 0;

        if(zero <= zeros && one <= ones){
            len2 = 1+solve(idx+1, zeros-zero, ones-one, strs);
        }

        return dp[idx][zeros][ones] = Math.max(len1, len2);
    }
}