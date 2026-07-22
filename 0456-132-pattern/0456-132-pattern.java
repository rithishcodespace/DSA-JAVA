// we go from n-1 to 0, coz we would be standing on nums[i], so it would to find whether nums[j] and nums[k]
// stack stores nums[j] (greatest in the pattern), and eventually every visited number could become nums[j]
// third stores nums[k]

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            if(nums[i] < third)return true; // nums[i] < nums[k] < nums[j]

            while(!stack.isEmpty() && nums[i] > stack.peek()){ // monotonically increasing array
                third = stack.pop(); // better candidate for nums[k]
            }

            stack.push(nums[i]); // not it became nums[j]
        }

        return false;
    }
}