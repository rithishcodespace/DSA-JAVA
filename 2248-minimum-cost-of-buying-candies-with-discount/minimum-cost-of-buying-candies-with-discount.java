class Solution {
    public int minimumCost(int[] cost) {
        int min_cost = 0, picked = 0;
        Arrays.sort(cost);

        for(int i=cost.length-1;i>=0;i--){
            picked++;

            if(picked <= 2){
                min_cost += cost[i];
            }
            else picked = 0;
        }       

        return min_cost;
    }
}