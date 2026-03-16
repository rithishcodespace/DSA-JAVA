class Solution {
    int invert = 0;
    public int minReorder(int n, int[][] connections) {
        int[] visited = new int[n];
        // create adj_list
        List<List<Integer>> adj_list = new ArrayList<>();
        List<List<Integer>> real_list = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj_list.add(new ArrayList<>());
            real_list.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            adj_list.get(connections[i][0]).add(connections[i][1]);
            adj_list.get(connections[i][1]).add(connections[i][0]);

            real_list.get(connections[i][0]).add(connections[i][1]);
        }
        visited[0] = 1;
        dfs(visited,adj_list,real_list,0,-1);
        return invert;
    }
    public void dfs(int[] visited, List<List<Integer>> adj_list, List<List<Integer>> real_list, int node, int prev){

        if(prev != -1){
            List<Integer> connections = real_list.get(node);
            if(!connections.contains(prev)){
                invert++;
            }
        }

        for(int i=0;i<adj_list.get(node).size();i++){
            if(visited[adj_list.get(node).get(i)] == 0){
                visited[adj_list.get(node).get(i)] = 1;
                dfs(visited, adj_list, real_list, adj_list.get(node).get(i), node);
            }
        }
    }
}