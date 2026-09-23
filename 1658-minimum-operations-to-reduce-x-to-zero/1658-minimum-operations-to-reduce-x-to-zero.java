// recursion: 2^n
// ans = longest subarray with sum (totalsum-x)

class Solution {
    public int minOperations(int[] nums, int x) {
        int totalsum = 0;
        
        for(int i=0;i<nums.length;i++){
            totalsum += nums[i];
        }

        int target = totalsum-x;

        if(totalsum < x)return -1;

        if(target == 0)return nums.length;

        // largest subarray with sum as target

        int l=0, r=0, sum=0, maxLen=0;

        while(r<nums.length){
            sum += nums[r];

            while(sum > target){
                sum -= nums[l++];
            }

            if(sum == target){
                maxLen = Math.max(maxLen, (r-l)+1);
            }

            r++;
        }

        return maxLen == 0 ? -1 : nums.length-maxLen;
    }
}