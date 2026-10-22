// solve it using the code of merge intervals

class Solution {
    public int[][] insert(int[][] temp_intervals, int[] newInterval) {
        // intervals are []
        if (temp_intervals.length == 0) {
            return new int[][] { newInterval };
        }
        
        // just add the new interval
        int[][] intervals = new int[temp_intervals.length+1][2];
        for(int i=0;i<temp_intervals.length;i++){
            intervals[i] = temp_intervals[i];
            if(i == temp_intervals.length-1)intervals[++i] = newInterval;
        }

        // merge interval code
        
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