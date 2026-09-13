// we logically delete nums[i]-1 and nums[i]+1
// if i delete 3, i get 3+3+3 = 9 as points, and i delete 2,4 for free

class Solution {
    public int deleteAndEarn(int[] nums) {
        // find max point
        int max = nums[0];
        for(int num : nums){
            max = Math.max(max, num);
        }

        // combine points of same value
        int[] points = new int[max+1];
        for(int x : nums){
            points[x] += x; // 3 -> 9, 2 -> 4
        }

        // start from 0 point
        Integer[] dp = new Integer[points.length];
        return solve(0, points, dp);
    }
    public int solve(int idx, int[] points, Integer[] dp){
        if(idx >= points.length){
            return 0;
        }

        if(dp[idx] != null)return dp[idx];

        // pick - logically i skip point+1 and eliminate point-1
        int pick = points[idx] + solve(idx+2, points, dp);

        // not-pick
        int not_pick = solve(idx+1, points, dp);

        return dp[idx] = Math.max(pick, not_pick);
    }
}