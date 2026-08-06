class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // create adjlist to do bfs and find the suspicious nodes
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> in = new ArrayList<>();
        List<Integer> whole = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();


        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            in.add(new ArrayList<>());
            whole.add(i);
        }

        for(int[] edge : invocations){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            in.get(v).add(u);
        }

        // bfs to get suspicious nodes
        List<Integer> susp = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visited[k] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            susp.add(node);

            for(int neigh : adj.get(node)){
                if(!visited[neigh]){
                    q.add(neigh);
                    visited[neigh] = true;
                }
            }
        }

        // calculate in degree of susp group
        // the edge to these nodes, should not be from one among them
        for(int u=0;u<n;u++){
            if(visited[u]){
                for(int v : in.get(u)){
                    if(!visited[v]){ // return everything
                        return whole;
                    }
                }
            }
            else ans.add(u);
        }

        return ans;
    }
}