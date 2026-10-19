// edge weights between 2 nodes is the manhatten distance

// prims algo
// - start with any node, push it into heap
// - pop, if visited skip, else
// - make it visited, sum edge weight from it's parentt to it
// - insert its neighbours

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int sum = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        minHeap.add(new int[]{0, 0}); // ( node, distance )

        int[] visited = new int[points.length];

        while(!minHeap.isEmpty()){
            int[] point = minHeap.poll();

            int node = point[0], dist = point[1];

            if(visited[node] == 0){
                visited[node] = 1;

                sum += dist;

                // add it's neighbours
                for(int i=0;i<points.length;i++){
                    if(visited[i] == 0){
                        int x1 = points[node][0], y1 = points[node][1];
                        int x2 = points[i][0], y2 = points[i][1];

                        int manhatten = Math.abs(x1-x2) + Math.abs(y1-y2);
                        minHeap.add(new int[]{i, manhatten});
                    }
                }
            }
        }

        return sum;
    }
}