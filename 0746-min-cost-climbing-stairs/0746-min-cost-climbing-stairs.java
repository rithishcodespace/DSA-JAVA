class Solution {

    HashMap<Integer,Integer> dp = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(solve(0, cost), solve(1, cost));
    }

    public int solve(int idx, int[] cost){
        if(idx >= cost.length){
            return 0;
        }

        if(dp.containsKey(idx))return dp.get(idx);

        int c1 = cost[idx] + solve(idx+1, cost);
        int c2 = cost[idx] + solve(idx+2, cost);

        dp.put(idx, Math.min(c1, c2));

        return dp.get(idx);
    }
}