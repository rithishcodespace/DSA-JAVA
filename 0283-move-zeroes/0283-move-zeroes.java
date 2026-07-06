// two pointers
// swap every non zero element to the j'th pointer
// i -> scan's entire array to find non zero index
// j -> says element where non-zero elemnt to be placed

// tc: O(n)
// sc: O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++; // next index to place a non-zero element
            }
        }
    }
}