class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l=0, r=0, max=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(r < nums.length){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);

            while(map.get(nums[r]) > k){
                map.put(nums[l], map.get(nums[l])-1);
                l++;
            }

            max = Math.max(max, r-l+1);

            r++;
        }

        return max;
    }
}