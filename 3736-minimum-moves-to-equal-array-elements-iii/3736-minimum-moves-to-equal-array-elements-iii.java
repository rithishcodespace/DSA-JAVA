class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0], moves = 0;

        for(int num : nums){
            max = Math.max(max, num);
        }

        for(int num : nums){
            moves += max-num;
        }

        return moves;
    }
}