// // partition dp

// // if cut at index i, start to i is finalized (left part) is finalized
// // recursion should handle right part 

// class Solution {
//     int MOD = 1000000007;
//     Integer[][] dp;
//     public int numberOfSets(int n, int k) {
//         if(k == n - 1){
//             return 1;
//         }
//         dp = new Integer[n+1][k+1];
//         return solve(0, n-1, k) % MOD;
//     }
//     public int solve(int l, int r, int k){
//         // base case
//         if(k == 0){
//             return 1;
//         }
//         if(l >= r){
//             return 0;
//         }

//         if(dp[l][k] != null)return dp[l][k];

//         long ways = 0;

//         // Point l is not used as the starting point of a segment. Move forward.
//         ways += solve(l+1, r, k);
//         ways %= MOD;

//         for(int i=l+1;i<=r;i++){ // should cover 2 or more points (l<r)
//             // Start a segment at l and end it at i.
//             ways += solve(i, r, k-1) % MOD; // since it is a segment, we dont use i+1
//             ways %= MOD;
//         }

//         return dp[l][k] = (int)ways;
//     }
// }

class Solution {

    int MOD = 1000000007;
    Integer[][] dp;
    Integer[][] sum;

    public int numberOfSets(int n, int k) {
        if (k == n - 1) {
            return 1;
        }

        dp = new Integer[n + 1][k + 1];
        sum = new Integer[n + 1][k + 1];

        return solve(0, n - 1, k);
    }

    public int solve(int l, int r, int k){

        // No more segments to create
        if (k == 0) {
            return 1;
        }

        // Not enough points
        if (r - l + 1 < k + 1) {
            return 0;
        }

        if (dp[l][k] != null) {
            return dp[l][k];
        }

        long ways = 0;

        // Don't use l as starting point
        ways += solve(l + 1, r, k);
        ways %= MOD;

        // Use l as starting point.

        ways += getSum(l + 1, r, k - 1);
        ways %= MOD;

        return dp[l][k] = (int) ways;
    }

    public int getSum(int l, int r, int k){

        if (l > r) {
            return 0;
        }

        // k = 0:
        // solve(i,r,0) = 1 for every i
        //
        // So the sum is simply number of positions.
        if(k == 0) {
            return r - l + 1;
        }

        if(sum[l][k] != null){
            return sum[l][k];
        }

        long ans = 0;

        // solve(l,r,k)
        ans += solve(l, r, k);
        ans %= MOD;

        // solve(l+1,r,k) + ...
        ans += getSum(l + 1, r, k);
        ans %= MOD;

        return sum[l][k] = (int) ans;
    }
}