class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1]; // end desceding
            }
            return a[0]-b[0]; // start ascending
        });
        int[] prev = new int[2];
        for(int i=0;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(list.isEmpty() || !(prev[0] <= curr[0] && curr[1] <= prev[1])){
                list.add(new int[]{curr[0], curr[1]});
                prev[0] = curr[0];
                prev[1] = curr[1];
            }
        }

        return list.size();
    }
}
// 1,4 2,8 3,6