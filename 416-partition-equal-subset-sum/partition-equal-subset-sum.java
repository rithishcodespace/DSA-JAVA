class Solution {
    public boolean canPartition(int[] nums) {
        // find sum of the elements
        int total_sum = 0;
        for(int i=0;i<nums.length;i++){
            total_sum += nums[i];
        }
        if(total_sum%2 == 1)return false; //  odd can't be splitted into equal parts
        // find If there is a subsequnce/subset whose sum is sum/2
        // If found, check whether the remaining elements sum == sum/2 (but mathematically no need to check)
        Boolean[][] dp = new Boolean[nums.length][(total_sum/2)+1];
        return solve(0, total_sum/2, nums, dp);
    }
    public static Boolean solve(int idx, int sum, int[] arr, Boolean[][] dp){
        if(sum == 0){
            return true;
        }
        
        if(idx >= arr.length){
            return false; 
        }
        
        
        if(dp[idx][sum] != null)return dp[idx][sum];
        
        // pick
        boolean pick = false;
        if(arr[idx] <= sum){
            pick = solve(idx+1, sum-arr[idx], arr, dp);
        }
        
        // not-pick
        Boolean not_pick = solve(idx+1, sum, arr, dp);
        
        
        dp[idx][sum] = (pick || not_pick);
        
        return dp[idx][sum];
    }
}