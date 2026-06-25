// sliding window

class Solution {
    public long countSubarrays(int[] nums, long k) {
        int l = 0, r = 0;
        long cnt = 0, sum = 0;

        while(r < nums.length){
            sum += nums[r];

            while((sum)*(r-l+1) >= k){
                sum -= nums[l];
                l++;
            }

            cnt += (r-l)+1;
            r++;
        }

        return cnt;
    }
}
