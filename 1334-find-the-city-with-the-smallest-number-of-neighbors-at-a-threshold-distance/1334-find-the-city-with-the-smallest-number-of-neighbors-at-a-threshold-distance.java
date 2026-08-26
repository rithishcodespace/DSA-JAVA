// floyd warshall

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int city = 0, minCount = Integer.MAX_VALUE;
        int[][] distance = new int[n][n];

        // fill all pairs with max
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // create adj list

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];

            distance[u][v] = d;
            distance[v][u] = d;
        }

        // fill 0, if both are same
        for(int i=0;i<n;i++){
            distance[i][i] = 0;
        }

        // pass through every nodes
        for(int i=0;i<n;i++){
            pass(distance, i);
        }

        // for each node count how much cities can be reached
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(distance[i][j] != Integer.MIN_VALUE && distance[i][j] <= distanceThreshold){
                    count++;
                }
            }

            if(count <= minCount){
                minCount = count;
                city = i;
            }
        }

        return city;
    }
    public void pass(int[][] distance, int node){
        for(int i=0;i<distance.length;i++){
            for(int j=0;j<distance.length;j++){
                if(distance[i][node] != Integer.MAX_VALUE && distance[node][j] != Integer.MAX_VALUE){
                    int newDistance = distance[i][node] + distance[node][j];
                    distance[i][j] = Math.min(distance[i][j], newDistance);
                }
            }
        }
    }
}