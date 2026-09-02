// tabulation
// dp[i] - lis ending at i

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1); // each index is a lis of length 1

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }

        return dp[nums.length-1];
    }
}