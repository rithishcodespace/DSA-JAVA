// goal is to reach n-1'th step from 0'th step with minimum overall cost

class Solution {
    Integer[] dp;
    public int climbStairs(int n, int[] costs) {
        dp = new Integer[n+1];
        return solve(0, n, costs);
    }
    public int solve(int currStep, int n, int[] costs){
        if(currStep == n){
            return 0;
        }

        if(dp[currStep] != null)return dp[currStep];

        int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE, three = Integer.MAX_VALUE;

        // i+1
        if(currStep+1 <= n){
            one = costs[currStep] + 1 + solve(currStep+1, n, costs);
        }
        // i+2
        if(currStep+2 <= n){
            two = costs[currStep+1] + 4 + solve(currStep+2, n, costs);
        }
        // i+3
        if(currStep+3 <= n){
            three = costs[currStep+2] + 9 + solve(currStep+3, n, costs);
        }

        return dp[currStep] = Math.min(one, Math.min(two, three));
    }
}