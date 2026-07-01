// fix one element, then solve Two Sum II on the rest.

// tc: O(logn) + O(n^2) -> O(n^2)
// sc : O(1)   (excluding the output list)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // convert to TWO SUM II
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){ // each range should have >= 3 numbers
            if(i > 0 && nums[i-1] == nums[i])continue; // don't use repeated same fixed element (to avoid duplicates)
            int x = i, y = i+1, z = nums.length-1;

            while(y<z){
                int sum = nums[x]+nums[y]+nums[z];

                if(sum == 0){
                    ans.add(Arrays.asList(nums[x], nums[y], nums[z]));
                    y++;z--;
                    while (y < z && nums[y] == nums[y - 1]){
                        y++;
                    }
                    while (y < z && nums[z] == nums[z + 1]){
                        z--;
                    }
                }
                else if(sum > 0){
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