// tabulation

// dp[i] = length of the longest increasing subsequence that ends at index i.
// count[i] = number of longest increasing subsequences of length dp[i] that end at index i.

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int maxLen=0, maxCount=0;
        int[] count = new int[nums.length];
        int[] dp = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            count[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }
                    else if(dp[j]+1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }

            // update
            if(maxLen < dp[i]){
                maxLen = dp[i];
                maxCount = count[i];
            }
            else if(dp[i] == maxLen){
                maxCount += count[i];
            }
        }

        return maxCount;
    }
}