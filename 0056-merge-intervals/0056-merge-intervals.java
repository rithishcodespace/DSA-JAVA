// y1 >= x2
// used stack to track curr and prev

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        Stack<int[]> stack = new Stack<>();

        for(int[] curr : intervals){
            if(!stack.isEmpty()){
                int[] prev = stack.peek();
                
                // overlap condition
                if(prev[1] >= curr[0]){
                    stack.pop();
                    stack.push(new int[]{prev[0], Math.max(prev[1], curr[1])});
                }
                else stack.push(curr);
            }
            else stack.push(curr);
        }

        int idx=0;
        int[][] ans = new int[stack.size()][2];
        for(int[] arr : stack){
            ans[idx++] = arr;
        }

        return ans;
    }
}