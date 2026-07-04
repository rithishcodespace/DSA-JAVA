// (rightMin - leftMin) * myHeight

// tc: O(n)
// sc: O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        int[] prevMin = new int[heights.length];
        int[] nextMin = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        // prevMin - monotonically increasing stack - (front to last)
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            prevMin[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }

        stack.clear();

        // nextMin - monotonically increasing stack - (back to front)
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            nextMin[i] = !stack.isEmpty() ? stack.peek() : heights.length;

            stack.push(i);
        }

        // consume width between nextMin and prevMin and record max Area
        for(int i=0;i<heights.length;i++){
            int area = (nextMin[i] - prevMin[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}