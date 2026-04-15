// DSU
class Solution {
    int[] parent;
    int[] size;
    int[] edge = new int[2];
    public int[] findRedundantConnection(int[][] edges) {
      parent = new int[edges.length+1];
      size = new int[edges.length+1];

      for(int i=1;i<=edges.length;i++){
        parent[i] = i;
        size[i] = 1;
      }  

      for(int i=0;i<edges.length;i++){
        int u = edges[i][0];
        int v = edges[i][1];

        union(u,v);
      }

      return edge;
    }
    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv){
            edge[0] = u;
            edge[1] = v;

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
    public int findParent(int node){
        if(node != parent[node]){
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }
}