// fix one element, then solve Two Sum II on the rest + instead of zero, find closest to target

// tc: O(logn) + O(n^2) -> O(n^2)
// sc : O(1)   (excluding the output list)

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];;

        // convert to TWO SUM II
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){ // each range should have >= 3 numbers
            int x = i, y = i+1, z = nums.length-1;

            while(y<z){
                int sum = nums[x]+nums[y]+nums[z];

                // maintain answer
                int curr_diff = Math.abs(sum-target);
                int ans_diff = Math.abs(ans-target);
                if(curr_diff < ans_diff){
                    ans = sum;
                }

                if(sum == target){
                    return target;
                }
                else if(sum > target){
                    z--; // r -> reduces sum
                }
                else{
                    y++; // l -> increases sum
                }
            }
        }

        return ans;
    }
}