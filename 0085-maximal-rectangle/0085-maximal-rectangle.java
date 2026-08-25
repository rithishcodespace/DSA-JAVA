class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int[][] transformed_matrix = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0){
                    transformed_matrix[i][j] = matrix[i][j]-'0';
                }
                else{
                    int above = transformed_matrix[i-1][j];
                    int below = matrix[i][j]-'0';
                    if(below == 0)transformed_matrix[i][j] = 0;
                    else transformed_matrix[i][j] = above+below;
                }
            }
            max = Math.max(max, largetRectangeInHistogram(transformed_matrix[i]));
        }

        return max;
    }
    public int largetRectangeInHistogram(int[] nums){
        int max = 0;
        int[] prevMin = new int[nums.length];
        int[] nextMin = new int[nums.length];

        Stack<Integer> stack = new Stack<>();

        // monotonically increasing stack - from back (nextMin)
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            nextMin[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // monotonically increasing stack - from front (prevMin)
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            prevMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // find area
        for(int i=0;i<nums.length;i++){
            int width = nextMin[i]-prevMin[i]-1;
            max = Math.max(max, nums[i]*width);
        }

        return max;
    }
}