class Solution {
    int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n+1][target+1];
        return solve(n, k, target, dp);
    }
    public int solve(int dices, int faces, int target, Integer[][] dp){
        // impossible case
        if(target < dices || target > dices * faces) {
            return 0;
        }
        
        // base case
        if(dices == 0 || target <= 0){
            return target == 0 ? 1 : 0;
        }

        if(dp[dices][target] != null)return dp[dices][target];

        // for i'th dice, try all upper faces
        long ways = 0;
        for(int i=1;i<=faces;i++){
            ways += solve(dices-1, faces, target-i, dp);
            ways %= MOD;
        }

        return dp[dices][target] = (int)ways;
    }
}