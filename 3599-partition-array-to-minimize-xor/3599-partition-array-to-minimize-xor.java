// PARTITION DP

// idx -> starting idx
// when you cut at an idex
// left part -> from starting idx to cutted index (finalized)
// right part -> from cutted index+1 to n (not finalized -> recusion will solve this)

class Solution {
    public int minXor(int[] nums, int k) {
        Integer[][] dp = new Integer[nums.length+1][k+1];

        // prefix XOR
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1]^nums[i];
        }

        return solve(0, k, nums, prefix, dp);
    }
    public int solve(int idx, int k, int[] nums, int[] prefix, Integer[][] dp){
        if(k == 1){
            return findXOR(idx, nums.length - 1, prefix);
        }

        if(dp[idx][k] != null)return dp[idx][k];

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // cut at available indexes
        for(int i = idx; i <= nums.length - k; i++){
            int left = findXOR(idx, i, prefix);
            int right = solve(i+1, k-1, nums, prefix, dp); // right

            max = Math.max(left, right); // max of partitions

            min = Math.min(min, max); // min of max
        }
        
        return dp[idx][k] = min;
    }
    public int findXOR(int l, int r, int[] prefix){
        return l == 0 ? prefix[r] : prefix[r] ^ prefix[l - 1];
    }
}