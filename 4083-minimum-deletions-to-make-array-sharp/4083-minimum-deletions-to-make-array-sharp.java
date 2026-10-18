// duplicate numbers should not be kept adjacent

class Solution {
    public int minDeletions(int[] nums) {
        int len = 1, del = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                len++;
            }
            else{
                if(len > 1)del += len-1;
                len = 1;
            }
        }

        if(len > 1)del += len-1;

        return del;
    }
}