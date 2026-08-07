// i can't rob 1'st and n'th house at same time
// arr1 -> houses without n'th house
// arr2 -> houses without 1'st house

class Solution {


    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        
        Integer[] dp1 = new Integer[nums.length];
        Integer[] dp2 = new Integer[nums.length];

        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];

        for(int i=0;i<nums.length-1;i++)arr1[i] = nums[i];
        for(int i=1;i<nums.length;i++)arr2[i-1] = nums[i];

        return Math.max(solve(0, arr1, dp1), solve(0, arr2, dp2));
    }

    public int solve(int idx, int[] nums, Integer[] dp){
        if(idx >= nums.length)return 0;

        if(dp[idx] != null)return dp[idx];

        // pick
        int pick = nums[idx] + solve(idx+2, nums, dp);
        // not pick
        int not_pick = 0 + solve(idx+1, nums, dp);

        return dp[idx] = Math.max(pick, not_pick);
    }
}