class Solution {
    public int findMiddleIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            prefix[i] = sum;
            sum += nums[i];
        }

        sum = 0;

        for(int i=nums.length-1;i>=0;i--){
            suffix[i] = sum;
            sum += nums[i];
        }

        for(int i=0;i<nums.length;i++){
            if(prefix[i] == suffix[i])return i;
        }

        return -1;
    }
}