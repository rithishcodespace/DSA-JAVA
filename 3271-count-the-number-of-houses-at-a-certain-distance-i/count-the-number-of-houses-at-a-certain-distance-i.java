class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        // create adj_matrix
        int[][] adj = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            Arrays.fill(adj[i],Integer.MAX_VALUE);
        }
        for(int i=1;i<n+1;i++){
            adj[i][i] = 0;
        }
        // add edges
        for(int i=1;i<adj.length;i++){
            int j=i+1;
            if(j<adj.length){
                adj[i][j] = 1;
                adj[j][i] = 1;
            }
        }
        adj[x][y] = 1;
        adj[y][x] = 1;
        // flowd-warshall
        for(int i=1;i<n+1;i++){
            flowd_warshall(i, adj);
        }
        // count pairs with k distances
        int[] ans = new int[n];
        for(int i=1;i<adj.length;i++){
            for(int j=1;j<adj.length;j++){
                int distance = adj[i][j];
                if(i == j || distance == Integer.MAX_VALUE) continue;
                ans[distance-1]++;
            }
        }
        return ans;
    }
    public void flowd_warshall(int node, int[][] adj){
        for(int i=1;i<adj.length;i++){
            for(int j=1;j<adj.length;j++){
                if(adj[i][node] != Integer.MAX_VALUE && adj[node][j] != Integer.MAX_VALUE){
                    int newDistance = adj[i][node] + adj[node][j];
                    adj[i][j] = Math.min(newDistance, adj[i][j]);
                }
            }
        }
    }
}