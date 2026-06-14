class Solution {
    public boolean predictTheWinner(int[] nums) {
        return solve(0, nums.length - 1, nums) >= 0;
    }
    // 1'st player - 2'nd players score
    public int solve(int i, int j, int[] nums) { 
        if(i == j){ // i have one option to pick (deciding factor)
            return nums[i];
        }

        int pickLeft = nums[i] - solve(i+1, j, nums);
        int pickRight = nums[j] - solve(i, j-1, nums);

        return Math.max(pickLeft, pickRight);
    }
}