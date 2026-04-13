// DSU
class Solution {
    int[] parent;
    int[] size;
    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length+1];
        size = new int[isConnected.length+1];

        // fill parent as themselves
        for(int i=1;i<=isConnected.length;i++){
            parent[i] = i;
            size[i] = 1;
        }

        // union all sets
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j] == 1){
                    if(i != j){
                        union(i+1,j+1);
                    }
                }
            }
        }

        // find no.of distinct parents in each set
        HashSet<Integer> set = new HashSet<>();
        for(int i=1;i<parent.length;i++){
            set.add(findParent(i));
        }

        return set.size();
    }
    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv)return;

        int u_size = size[pu];
        int v_size = size[pv];

        if(u_size > v_size){
            parent[pv] = parent[pu];
            size[pu] += size[pv];
        }
        else{
            parent[pu] = parent[pv];
            size[pv] += size[pu];
        }
    }
    public int findParent(int node){
        if(parent[node] != node){
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }
}