// tarjans

// tin - time of insertion (time when dfs reached this node)
// low = lowest time of insertion (min of low among it's adjacent nodes, except parent node)

// if (parent[tin] < child[low]) -> it is a bridge, since child has no way to reach father node

class Solution {

    List<List<Integer>> bridges = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(List<Integer> edge : connections){
            int u = edge.get(0), v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // tarjans
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] visited = new int[n];

        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(i, -1, 0, tin, low, adj, visited);
            }
        }

        return bridges;
    }

    public void dfs(int u, int parent, int time, int[] tin, int[] low, List<List<Integer>> adj, int[] visited){
        tin[u] = low[u] = time++;
        visited[u] = 1;

        for(int v : adj.get(u)){
            if(v == parent)continue; // since parent -- child is only to for bridge prediction (done via recursion
        
            if(visited[v] == 0){
                dfs(v, u, time, tin, low, adj, visited);

                // my all adj nodes are visted, now decide which to choose as low for u
                low[u] = Math.min(low[u], low[v]);

                // now check whether u -- v is a bridge
                if(tin[u] < low[v]){
                    bridges.add(Arrays.asList(u,v));
                }
            }
            else{ // since neigh visited, use it's low to update current low
                low[u] = Math.min(low[u], low[v]);
            }
        }
    }
}