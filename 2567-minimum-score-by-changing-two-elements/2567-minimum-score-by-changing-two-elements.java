class Solution {
    public int minimizeSum(int[] nums) {
      Arrays.sort(nums);

      int[] arr = new int[3];
      arr[1] = nums[nums.length - 1]-nums[2];  //first two
      arr[0] = nums[nums.length - 2]-nums[1]; //first and last 
      arr[2] = nums[nums.length - 3]-nums[0]; //last two
      
      return Math.min(Math.min(arr[0],arr[1]),arr[2]); 
    }
}