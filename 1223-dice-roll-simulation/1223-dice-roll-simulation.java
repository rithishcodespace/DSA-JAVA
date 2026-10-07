class Solution {
    int MOD = 1000000007;
    public int dieSimulator(int n, int[] rollMax) {
        Integer[][][] dp = new Integer[7][16][n+1];
        return solve(-1, 0, n, rollMax, dp)%MOD;
    }
    public int solve(int prev, int freq, int n, int[] rollMax, Integer[][][] dp){
        if(n == 0)return 1;

        if(prev != -1 && dp[prev][freq][n] != null)return dp[prev][freq][n];

        int count = 0;

        for(int i=1;i<=6;i++){
            int curr = i;

            if(prev == curr){
                if(freq+1 <= rollMax[curr-1]){
                    count += solve(curr, freq+1, n-1, rollMax, dp);
                }
            }
            else{
                count += solve(curr, 1, n-1, rollMax, dp);
            }
            
            count %= MOD;
        }

        if(prev != -1)dp[prev][freq][n] = count;

        return count;
    }
}