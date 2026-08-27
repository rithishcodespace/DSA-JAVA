// tarjans algo

// find time of insertion, lowest insertion time
// tin - time when the node is visited
// low - lowest tin of all adjacent node, except parent node

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // build adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(List<Integer> connection : connections){
            int u = connection.get(0);
            int v = connection.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // dfs with alterations
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] visited = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(i, 0, -1, tin, low, visited, adj, bridges);
            }
        }

        return bridges;
    }
    public void dfs(int u, int parent, int time, int[] tin, int[] low, int[] visited, List<List<Integer>> adj, List<List<Integer>> bridge){
        visited[u] = 1;
        
        tin[u] = low[u] = time++; // time should be globally unique

        for(int v : adj.get(u)){
            if(v == parent)continue;

            if(visited[v] == 0){
                dfs(v, u, time, tin, low, visited, adj, bridge);

                // my all adj nodes are visted, now decide which to choose as low for u
                low[u] = Math.min(low[u], low[v]);

                // check whether u-v is a bridge
                if(tin[u] < low[v]){
                    bridge.add(Arrays.asList(u,v));
                }
            }
            else{
                low[u] = Math.min(low[u], low[v]);
            }
        }

    }
}