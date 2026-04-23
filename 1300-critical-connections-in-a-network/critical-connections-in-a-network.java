class Solution {

    int time = 0;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // build the adj_list, time of insertion and lowest inserted node
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj_list.add(new ArrayList<>());
        }
        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);

            adj_list.get(u).add(v);
            adj_list.get(v).add(u);
        }

        int[] tin = new int[n];
        int[] low = new int[n];
        int[] visited = new int[n];

        // dfs
        dfs(0, -1, tin, low, visited, adj_list);

        return ans;
    }

    public void dfs(int node, int parent, int[] tin, int[] low, int[] visited, List<List<Integer>> adj_list){
        visited[node] = 1;

        tin[node] = low[node] = time;
        time++;

        for(int v : adj_list.get(node)){
            if(v == parent)continue; // avoid parent, since the breaking of edge need to be between parent and child, we need to find an alternative way without parent

            if(visited[v] == 0){
                dfs(v, node, tin, low, visited, adj_list);

                // after completing the recursive call's of v
                low[node] = Math.min(low[v],low[node]);

                // check whether node --- v edge is a bridge 
                if(low[v] > tin[node]){
                    ans.add(Arrays.asList(node, v));
                }
            }
            else{
                // back edge
                low[node] = Math.min(low[node],tin[v]);
            }
        }
    }
}