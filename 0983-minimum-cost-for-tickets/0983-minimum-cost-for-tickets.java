class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] dp = new Integer[days.length];
        return solve(0, days, costs, dp);
    }
    public int solve(int idx, int[] days, int[] costs, Integer[] dp){
        if(idx >= days.length){
            return 0;
        }

        if(dp[idx] != null)return dp[idx];

        // buy one day
        int dayCost = costs[0] + solve(idx+1, days, costs, dp);
        // buy a week
        int weekIdx = upperBound(idx, days[idx]+6, days);
        int weekCost = costs[1] + solve(weekIdx, days, costs, dp);
        // buy a month
        int monthIdx = upperBound(idx, days[idx]+29, days);
        int monthCost = costs[2] + solve(monthIdx, days, costs, dp);

        return dp[idx] = Math.min(dayCost, Math.min(weekCost, monthCost));
    }
    public int upperBound(int idx, int target, int[] days){
        int l=idx, r=days.length-1, ans=days.length;

        while(l <= r){
            int mid = (l+r)/2;

            if(days[mid] > target){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return ans;
    }
}