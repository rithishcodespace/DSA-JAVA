// to connect N components we need N-1 edges (min requirement)
// to count extra edges (use technique used in kruskal's algo to )
class Solution {
    int extra = 0;
    int[] parent;
    int[] size;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        // buidl graph with edges one by one and count eliminated edges
        for(int[] edge : connections){
            union(edge[0], edge[1]);
        }

        // count components by using their ultimate parent
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<parent.length;i++){
            set.add(findParent(i));
        }

        int components = set.size();


        if(extra >= components-1){
            return components-1;
        }
        return -1;
    }
    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv){
            extra++;
            return;
        }

        int u_size = size[pu];
        int v_size = size[pv];

        if(u_size > v_size){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
    public int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }
}