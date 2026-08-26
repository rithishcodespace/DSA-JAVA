// minimum spanning tree - prims algo

// v -> points[v][0], points[v][0]

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int mst = 0;

        boolean[] visited = new boolean[points.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); // [vertex, cost]

        // insert any vertex
        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int u = cell[0];
            int d = cell[1];

            if(!visited[u]){
                visited[u] = true; // i got process, so mark as visited
                mst += d;

                // insert my connections (since there is no edge, all vertex's are connected to me)
                for(int v=0;v<points.length;v++){
                    if(!visited[v]){
                        int distance = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                        pq.add(new int[]{v, distance});
                    }
                }
            }
        }

        return mst;
    }
}