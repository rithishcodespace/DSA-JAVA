// minimum spanning tree - kruskal algo

// v -> points[v][0], points[v][0]

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int mst = 0, edgesUsed = 0;

        int[] size = new int[points.length];
        int[] parent = new int[points.length];

        for(int i=0;i<points.length;i++){
            size[i] = 1;
            parent[i] = i;
        }

        List<int[]> edges = new ArrayList<>();

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, distance});
            }
        }

        Collections.sort(edges, (a,b) -> a[2] - b[2]);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];

            int pu = find(u, parent);
            int pv = find(v, parent);

            if(pu != pv){
                mst += d;
                edgesUsed++;

                union(pu, pv, parent, size);
            }

            if(edgesUsed == points.length-1)break;
        }

        return mst;
    }
    public int find(int node, int[] parent){
        if(parent[node] != node){
            parent[node] = find(parent[node], parent); // path compression
        }

        return parent[node];
    }
    public void union(int u, int v, int[] parent, int[] size){
        int pu = find(u, parent);
        int pv = find(v, parent);

        if(pu == pv)return;

        if(size[pu] > size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}