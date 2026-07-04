// next greater element concept - monotoncically decreasing stack (last to front)
// tc: O(n)
// sc: O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=temperatures.length-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek()-i : 0;

            stack.push(i);
        }

        return ans;
    }
}