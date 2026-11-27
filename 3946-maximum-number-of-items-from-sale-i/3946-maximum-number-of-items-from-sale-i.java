class Solution {
    Integer[][][] dp;
    int[][] items;
    int[] bonus;
    int n;
    public int maximumSaleItems(int[][] items, int budget){

        this.items = items;
        this.n = items.length;

        bonus = new int[n];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++) {

                if(i != j && items[j][0] % items[i][0] == 0) {
                    bonus[i]++;
                }
            }
        }

        dp = new Integer[n][budget + 1][2];

        return solve(0, budget, 0);
    }

    private int solve(int item, int budget, int started) {

        if(item == n) {
            return 0;
        }

        if(dp[item][budget][started] != null) {
            return dp[item][budget][started];
        }

        int price = items[item][1];

        int ans;

        if(started == 0) {

            // Skip this item completely
            ans = solve(item + 1, budget, 0);

            // Buy first copy
            if(budget >= price) {

                ans = Math.max(
                    ans,
                    bonus[item] + 1 +
                    solve(item, budget - price, 1)
                );
            }

        } else {

            // Move to next item
            ans = solve(item + 1, budget, 0);

            // Buy one more copy
            if(budget >= price) {

                ans = Math.max(
                    ans,
                    1 +
                    solve(item, budget - price, 1)
                );
            }
        }

        return dp[item][budget][started] = ans;
    }
}