// using floyd-warshall create distance matrix, and find citie's that can reach small no.of cities within threshold distance

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // create adj matrix
        int[][] distance = new int[n][n];

        for(int i=0;i<n;i++){ 
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++){ // [i][i]
            distance[i][i] = 0;
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1], dist = edge[2];

            distance[u][v] = dist;
            distance[v][u] = dist;
        }

        // pass through every node
        for(int i=0;i<n;i++){
            pass(i, distance);
        }

        // find the node that travelled less cities (if more pick the min number city)
        int minCity = -1, Mincount = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(i != j && distance[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(Mincount >= count){
                Mincount = count;
                minCity = i;
            }
        }

        return minCity;
    }
    public void pass(int v,int[][] distance){
        for(int i=0;i<distance.length;i++){
            for(int j=0;j<distance.length;j++){
                if(distance[i][v] != Integer.MAX_VALUE && distance[v][j] != Integer.MAX_VALUE){
                    int newDistance = distance[i][v] + distance[v][j];
                    if(newDistance < distance[i][j]){
                        distance[i][j] = newDistance;
                    }
                }
            }
        }
    }
}

class Element{

}