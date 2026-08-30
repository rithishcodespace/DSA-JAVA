class Solution {
    public int minimumDeletions(int[] nums) {
        // find min, max index
        int minIdx = 0, maxIdx = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] < nums[minIdx]){
                minIdx = i;
            }
            if(nums[i] > nums[maxIdx]){
                maxIdx = i;
            }
        }

        int choice1 = Math.max(minIdx, maxIdx)+1;
        int choice2 = 0;
        int choice3 = nums.length - Math.min(minIdx, maxIdx);
   
        if(minIdx < maxIdx){
          choice2 = (minIdx+1) + (nums.length-maxIdx);
        }
        else{
          choice2 = (maxIdx+1) + (nums.length-minIdx);
        }

        return Math.min(choice1, Math.min(choice2, choice3));
    }
}