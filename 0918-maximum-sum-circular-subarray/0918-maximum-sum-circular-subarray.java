class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total_sum = 0;
        int curr_max = 0, curr_min = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int num : nums){
            total_sum += num;

            curr_max = Math.max(num, curr_max+num);
            max = Math.max(max, curr_max);

            curr_min = Math.min(num, curr_min+num);
            min = Math.min(min, curr_min);
        }

        if(max < 0)return max;

        return Math.max(max, total_sum-min);
    }
}