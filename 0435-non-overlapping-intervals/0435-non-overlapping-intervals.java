// If 2 intervals overlap, remove the interval with that end ends later (coz it may affect future intervals too)

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        int cnt=0;
        Stack<int[]> stack = new Stack<>();

        for(int[] curr : intervals){
            if(!stack.isEmpty()){
                int[] prev = stack.peek();

                if(prev[1] > curr[0]){
                    cnt++;
                    // keep the interval that ends earlier
                    if(prev[1] > curr[1]){
                        stack.pop();
                        stack.add(curr);
                    }
                }
                else stack.push(curr);
            }
            else stack.push(curr);
        }

        return cnt;
    }
}