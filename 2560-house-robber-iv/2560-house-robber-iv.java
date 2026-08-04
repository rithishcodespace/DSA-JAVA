class Solution {
    public int minCapability(int[] nums, int k) {
        int l=Integer.MAX_VALUE, r=Integer.MIN_VALUE;

        for(int num : nums){
            l = Math.min(num, l);
            r = Math.max(num, r);
        }

        while(l <= r){
            int mid = l+(r-l)/2;

            if(canRob(mid, nums) >= k){
                r = mid-1;
            }
            else l = mid+1;
        }

        return l;
    }
    public int canRob(int cap, int[] nums){
        int count = 0;

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(num <= cap){
                count++;
                i++;
            }   
        }

        return count;
    }
}