// edge weights between 2 nodes is the manhatten distance

// kruskal's algo
// - sort the edges via edge weight
// - union the nodes (edge) if they dont not form cycle (not already in same component)
// - if you created n-1 nodes, stop don't proceed further

class Solution {

    int[] parent;
    int[] size;

    public int minCostConnectPoints(int[][] points) {
        parent = new int[points.length];
        size = new int[points.length];

        for(int i=0;i<points.length;i++){
            parent[i] = i;
            size[i] = 1;
        }

        // sort the edges via edge weights
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            int x1 = points[i][0], y1 = points[i][1];
            for(int j=i+1;j<points.length;j++){
                int x2 = points[j][0], y2 = points[j][1];

                int distance = Math.abs(x1-x2) + Math.abs(y1-y2);
                edges.add(new int[]{i, j, distance}); // node1, node2, distance
            }
        }
        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        // union edges
        int edgesUsed=0, sum=0;
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];

            if(findParent(u) == findParent(v))continue;

            union(u, v);
            edgesUsed++;
            sum += edge[2];

            if(edgesUsed == points.length-1)break;
        }

        return sum;
    }

    public int findParent(int x){
        if(x != parent[x]){
            parent[x] = findParent(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y){
        int px = findParent(x);
        int py = findParent(y);

        if(px == py){
            return;
        }

        if(size[px] < size[py]){
            size[py] += size[px];
            parent[px] = py;
        }
        else{
            size[px] += size[py];
            parent[py] = px;
        }
    }
}