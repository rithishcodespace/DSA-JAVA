// if union of 2 nodes, which has same ultimate parent, it creates a cycle 

class Solution {
    int[] parent;
    int[] size;
    int[] ans = new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        size = new int[edges.length+1];

        for(int i=1;i<edges.length+1;i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            union(u, v);
        }

        return ans;
    }
    public int findParent(int x){
        if(x != parent[x]){
            parent[x] = findParent(parent[x]);
        }

        return parent[x];
    }
    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv){
            ans[0] = u;
            ans[1] = v;
            return;
        }

        if(size[pu] < size[pv]){
            size[pv] += size[pu];
            parent[pu] = pv;
        }
        else{
            size[pu] += size[pv];
            parent[pv] = pu;
        }
    }
}