// instead of storing next greater in array, used hmap to cut off the nested loop used in previous submission

// tc: O(nums1 + nums2)
// sc: O(n)

// monotonically decreasing stack (back to front)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }
            map.put(nums2[i], (stack.isEmpty()) ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        // reduced to single loop via map
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}