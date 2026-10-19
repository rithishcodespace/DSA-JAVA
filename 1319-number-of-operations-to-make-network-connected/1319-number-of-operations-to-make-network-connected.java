// for connecting N components we need atleast N-1 edges
// if a edges connects nodes, that are already in the same component, it is an extra edge

class Solution {

    int extra=0;
    int[] parent;
    int[] size;

    public int makeConnected(int n, int[][] connections) {
        // invalid condition
        if(connections.length < n-1){
            return -1;
        }

        // DSU
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }    

        for(int[] edge : connections){
            int u = edge[0], v = edge[1];

            union(u, v);
        }
        
        // find the no.of connected components, by using parent counts
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(findParent(i));
        }

        int components = set.size();

        if(extra >= components-1){
            return components-1;
        }

        return -1;
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
            extra++;
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