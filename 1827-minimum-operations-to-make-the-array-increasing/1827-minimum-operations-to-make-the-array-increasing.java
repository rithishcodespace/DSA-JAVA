class Solution {
    public int minOperations(int[] nums) {
        int op = 0;
        
        for(int i=1;i<nums.length;i++){
            int prev = nums[i-1];
            int curr = nums[i];

            if(curr <= prev){
                int diff = Math.abs(prev-curr)+1;
                nums[i] += diff;
                op += diff;
            }
        }

        return op;
    }
}