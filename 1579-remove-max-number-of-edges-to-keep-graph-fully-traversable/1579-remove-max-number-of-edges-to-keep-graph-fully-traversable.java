// use 2 DSU instances, one for alice and another for bob

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int removed = 0;

        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        // connect all type 3 nodes
        for(int[] edge : edges){
            int type = edge[0], u = edge[1], v = edge[2];

            if(type == 3){
                boolean a = alice.union(u, v);
                boolean b = bob.union(u, v);

                if(!a && !b){
                    removed++;
                }
            }
        }

        // connect all type 2 nodes
        for(int[] edge : edges){
            int type = edge[0], u = edge[1], v = edge[2];

            if(type == 2){
                boolean b = bob.union(u, v);

                if(!b){
                    removed++;
                }
            }
        }

        // connect all type 1 nodes
        for(int[] edge : edges){
            int type = edge[0], u = edge[1], v = edge[2];

            if(type == 1){
                boolean a = alice.union(u, v);

                if(!a){
                    removed++;
                }
            }
        }

        // if alice and bob can't reach every node
        if(alice.edges != 0 || bob.edges != 0)return -1;

        return removed;
    }
}
class DSU{
    int[] parent;
    int[] size;
    int edges;

    DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];
        edges = n-1;

        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int findParent(int x){
        if(parent[x] != x){
            parent[x] = findParent(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int x, int y){
        int px = findParent(x);
        int py = findParent(y);

        if(px == py){
            return false;
        }

        if(size[px] < size[py]){
            size[py] += size[px];
            parent[px] = py;
        }
        else{
            size[px] += size[py];
            parent[py] = px;
        }

        edges--;

        return true;
    }
}