// front partition

class Solution {
    Integer[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return solve(0, k, arr);
    }
    public int solve(int idx, int k, int[] arr){
        if(idx == arr.length){
            return 0;
        }

        if(dp[idx] != null){
            return dp[idx];
        }

        int maxSum = 0, maxNum = arr[idx];

        for(int j=idx;j<Math.min(idx+k, arr.length);j++){
            maxNum = Math.max(maxNum, arr[j]);
            int sum = maxNum * (j-idx+1) + solve(j+1, k, arr);
            maxSum = Math.max(maxSum, sum);
        }

        dp[idx] = maxSum;

        return dp[idx];
    }
}