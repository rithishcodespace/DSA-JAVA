class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        Integer[][] dp = new Integer[cuts.length][cuts.length];
        return solve(0, cuts.length-1, n, cuts, dp);
    }
    public int solve(int l, int r, int n, int[] cuts, Integer[][] dp){
        if(l>r)return 0;

        if(dp[l][r] != null)return dp[l][r];

        int min = Integer.MAX_VALUE;

        for(int k=l;k<=r;k++){
            int left = l-1 < 0 ? 0 : cuts[l-1];
            int right = r+1 >= cuts.length ? n : cuts[r+1];

            int cost = (right-left) + solve(l, k-1, n, cuts, dp) + solve(k+1, r, n, cuts, dp);
            min = Math.min(min, cost);
        }

        return dp[l][r] = min;
    }
}