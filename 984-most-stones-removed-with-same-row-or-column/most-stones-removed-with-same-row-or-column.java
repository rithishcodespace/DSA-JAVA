class Solution {

    int[] parent;
    int[] size;

    public int removeStones(int[][] stones) {
        int max_row = 0, max_col = 0;
        for(int[] s : stones){
            max_row = Math.max(max_row, s[0]);
            max_col = Math.max(max_col, s[1]);
        }
        parent = new int[max_row + max_col + 2];
        size = new int[max_row + max_col + 2];

        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            size[i] = 1;
        }

        // form components
        for(int[] s : stones){
            int r = s[0];
            int c = s[1] + max_row + 1;

            union(r,c);
        }

        // find no of components
        HashSet<Integer> set = new HashSet<>();
        for(int[] s : stones){
            set.add(findParent(s[0]));
        }

        return stones.length - set.size();
    }
    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv)return;

        int size_u = size[pu];
        int size_v = size[pv];

        if(size_u > size_v){
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