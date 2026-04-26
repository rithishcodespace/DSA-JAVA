class Solution {
    int cnt = 1;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // create adj_list
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj_list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj_list.get(u).add(v);
            adj_list.get(v).add(u);
        }

        // create restricted map
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i=0;i<restricted.length;i++){
            res.put(restricted[i],1);
        }

        // dfs from unvisited nodes
        int[] visited = new int[n];

        dfs(0,res,adj_list,visited);
        visited[0]=1;

        return cnt;
    }
    public void dfs(int node, HashMap<Integer,Integer> res, List<List<Integer>> adj_list, int[] visited){
        visited[node] = 1;

        for(int i=0;i<adj_list.get(node).size();i++){
            int v = adj_list.get(node).get(i);

            if(visited[v] == 0 && !res.containsKey(v)){
                dfs(v, res, adj_list, visited);
                cnt++;
            }
        }
    }
}