// each recursive call returns alice's score
// Alice's turn → maximize Alice's score
// Bob's turn   → minimize Alice's score

class Solution {
    Integer[][][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new Integer[2][n + 1][n];
        return solve(0, 1, 0, piles);
    }
    public int solve(int turn, int M, int startIdx, int[] piles){ // turn (0) -> alice, turn (1) -> bobl
        if(startIdx >= piles.length)return 0;

        if(dp[turn][M][startIdx] != null)return dp[turn][M][startIdx];

        int sum = 0, stones = (turn == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for(int i=startIdx;i<Math.min(startIdx + M*2, piles.length);i++){
            sum += piles[i];
            int X = i-startIdx + 1;

            int future = solve((turn == 0) ? 1 : 0, Math.max(M, X), i+1, piles); // alice score from [i+1 to piles.length]
            
            if(turn == 0){ // alice
                stones = Math.max(stones, sum+future);
            }
            else{ // bob
                stones = Math.min(stones, future);
            }
        }

        return dp[turn][M][startIdx] = stones;
    }
}