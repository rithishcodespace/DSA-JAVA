class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l=0, bits=0, max=1;

        for(int r=0;r<nums.length;r++){
            while((bits & nums[r]) != 0){ // can i include nums[r] with current subarray
                bits = bits^nums[l++]; // remove left most elements until this slide becomes valid
            }

            // now add nums[r] to bitmask
            bits = bits | nums[r];

            max = Math.max(max, r-l+1);
        }

        return max;
    }
}