// sort the intervals array
// each each q (put eligible intervals in minheap)
// sort the query, so that for each next query we only add new intervals, and don't look for intervals we already seen

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] ans = new int[queries.length];

        Arrays.sort(intervals, (a,b) -> {
            return (a[0] == b[0]) ? a[1]-b[1] : a[0]-b[0];
        });

        int[][] sortedQueries = new int[queries.length][2]; // query, orgIdx

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a,b) -> a[0]-b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[2]-b[2]);

        int j=0;

        for(int[] query : sortedQueries){
            int q = query[0];
            int idx = query[1];

            // add eligible intervals
            while(j < intervals.length && intervals[j][0] <= q){
                int width = intervals[j][1]-intervals[j][0]+1;

                minHeap.add(new int[]{intervals[j][0], intervals[j][1], width});

                j++;
            }

            // remove ineligile intervals
            while(!minHeap.isEmpty() && minHeap.peek()[1] < q){
                minHeap.poll();
            }

            ans[idx] = !minHeap.isEmpty() ? minHeap.peek()[2] : -1;
        }

        return ans;
    }
}