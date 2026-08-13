class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = nums[0], ans = 0;

        for(int num : nums){
            max = Math.max(max, num);
        }

        while(k-- > 0){
            ans += max;
            max++;
        }

        return ans;
    }
}