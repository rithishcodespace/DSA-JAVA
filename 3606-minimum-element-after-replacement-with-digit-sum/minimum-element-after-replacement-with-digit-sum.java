class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int val = sum(nums[i]);
            min = Math.min(min,val);
        }
        return min;
    }
    public int sum(int num){
        int val = 0;
        while(num > 0){
            val += num%10;
            num /= 10;
        }
        return val;
    }
}