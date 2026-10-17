// dfs

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int[] visited = new int[isConnected.length+1];

        // create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=isConnected.length;i++)adj.add(new ArrayList<>());        

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i+1).add(j+1);
                }
            }
        }

        // start dfs from unvisited node
        for(int i=1;i<=isConnected.length;i++){
            if(visited[i] == 0){
                provinces++;
                dfs(i, visited, adj);
            }
        }

        return provinces;
    }
    public void dfs(int u, int[] visited, List<List<Integer>> adj){
        visited[u] = 1;

        for(int v : adj.get(u)){
            if(visited[v] == 0)dfs(v, visited, adj);
        }
    }
}