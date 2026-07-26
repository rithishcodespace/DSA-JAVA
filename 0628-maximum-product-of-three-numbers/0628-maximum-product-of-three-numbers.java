class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int c1 = nums[0]*nums[1]*nums[2];
        int c2 = nums[0]*nums[1]*nums[nums.length-1];
        int c3 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];

        return Math.max(c1, Math.max(c2,c3));
    }
}