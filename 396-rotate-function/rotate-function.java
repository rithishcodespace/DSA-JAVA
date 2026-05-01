class Solution {
    public int maxRotateFunction(int[] nums) {
        // F(0) and sum
        int sum = 0, F = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            F += i*nums[i];
        }
        int max = F;
        // find F from 1 to n-1
        for(int i=1;i<nums.length;i++){
            F = F + sum - (nums.length*nums[nums.length-i]);
            max = Math.max(F,max);
        }
        return max;
    }
}