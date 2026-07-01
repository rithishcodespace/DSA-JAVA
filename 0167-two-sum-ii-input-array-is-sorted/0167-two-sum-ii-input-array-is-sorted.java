// tc: O(n)
// sc: O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int[] ans = new int[2];
        while(l<r){
            int sum = nums[l]+nums[r];
            if(sum == target){
                ans[0] = l+1;
                ans[1] = r+1;
                return ans;
            }
            else if(sum < target){ // increase the sum
                l++;
            }
            else{ // decrease the sum
                r--;
            }
        }
        return ans;
    }
}