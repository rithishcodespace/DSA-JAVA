// every element inside the subarray should have same remainder

class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int max=1, l=0, r=0;

        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]%k;
        }

        while(r<nums.length){
            if(nums[l] != nums[r]){
                l=r; // start from r
            }

            long sum = (long)(nums[r] * (r-l+1)); // sum of remainders in the range

            if(sum%k == nums[r]){
                max = Math.max(max, r-l+1);
            }

            r++;
        }

        return max;
    }
}