class Solution {
    public int maximalSquare(char[][] matrix) {
        // construct the histogram
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }
                else{
                    heights[j]=0;
                }
            }
            int area = largestSquareInTheHistogram(heights);
            maxArea = Math.max(area,maxArea);
        }

        return maxArea;
    }
    public int largestSquareInTheHistogram(int[] heights){
        int[] prevMin = new int[heights.length];
        int[] nextMin = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        // monotonically increasing (back -> front) NEXT_MIN
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            nextMin[i] = (stack.isEmpty()) ? heights.length : stack.peek();
            stack.push(i);
        }
        stack.clear();

        // monotonically increasing (front -> back) PREV_MIN
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            prevMin[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        // find the area of the current row
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int width = nextMin[i]-prevMin[i]-1;
            // make area as square
            int area = (int)Math.min(heights[i],width)*Math.min(heights[i],width);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}