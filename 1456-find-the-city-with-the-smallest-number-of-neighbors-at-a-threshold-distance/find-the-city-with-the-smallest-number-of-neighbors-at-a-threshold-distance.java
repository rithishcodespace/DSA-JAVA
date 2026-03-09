class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // create adj_matrix
        int[][] adj_matrix = new int[n][n];
        // fill every node with infinity
        for(int i=0;i<adj_matrix.length;i++){
            Arrays.fill(adj_matrix[i],Integer.MAX_VALUE);
        }
        // fill the edge weights
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj_matrix[u][v] = wt;
            adj_matrix[v][u] = wt;
        }
        // make distance between same nodes as 0
        for(int i=0;i<n;i++){
            adj_matrix[i][i] = 0;
        }

        floyd_warshall(adj_matrix, n);

        int min = 0; // min no of cites can be reached (overall)
        int[] cities = new int[n]; // no of cities can be reached from each city

        for(int i=0;i<adj_matrix.length;i++){
            for(int j=0;j<adj_matrix[0].length;j++){
                if(i != j && adj_matrix[i][j] != Integer.MAX_VALUE && adj_matrix[i][j] <= distanceThreshold){
                    cities[i]++;
                }

            }
            if(cities[min] >= cities[i]){
                min = i;
            }
        }

        return min;
    }
    public void floyd_warshall(int[][] adj_matrix, int n){
        for(int i=0;i<n;i++){
            pass(adj_matrix, i);
        }
    }
    public void pass(int[][] adj_matrix, int node){
        for(int i=0;i<adj_matrix.length;i++){
            for(int j=0;j<adj_matrix[0].length;j++){
                if(adj_matrix[i][node] != Integer.MAX_VALUE && adj_matrix[node][j] != Integer.MAX_VALUE){
                    int new_wt = adj_matrix[i][node] + adj_matrix[node][j];
                    adj_matrix[i][j] = Math.min(adj_matrix[i][j],new_wt);
                }
            }
        }
    }
}