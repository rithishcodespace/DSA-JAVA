// prev = prev+1 ]
// curr = curr+1 ] inside dp table (to avoid -1 and n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] curr = new int[n+1];
        int[] next = new int[n+1];

        // base case
        // dp[n][0,..,n-1] = 0;

        // i goes from n-1 to 0
        for (int currIdx = n - 1;currIdx >= 0;currIdx--) {
            for (int prev = currIdx - 1; prev >= -1; prev--) {

                int pick = 0;

                if (prev == -1 || nums[currIdx] > nums[prev]) {
                    pick = 1 + next[currIdx + 1];
                }

                int notPick = 0 + next[prev + 1];

                curr[prev + 1] = Math.max(pick, notPick);
            }
            next = curr.clone();
        }

        return next[0];
    }
}