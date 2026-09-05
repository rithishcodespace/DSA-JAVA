// BFS

// keep different node's as source, which exposes different cycles
// if i reach a node, that is already visited in bfs, then is a cycle
// cycleLen = dist[u]+dist[v]+1

class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        int minCycle = Integer.MAX_VALUE;
        // create adj_list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // do bfs from each node
        for(int source=0;source<n;source++){
            int[] dist = new int[n];
            int[] parent = new int[n];

            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            dist[source] = 0;

            while(!queue.isEmpty()){
                int u = queue.poll();

                for(int v : adj.get(u)){
                    if(v == parent[u])continue;
                    if(dist[v] == -1){ // visiting first time
                        dist[v] = dist[u]+1;
                        parent[v] = u;
                        queue.add(v);
                    }
                    else{ // already visited by another node (cycle)
                        int cycleLen = dist[v]+dist[u]+1; // from source to v + from source to current(u), from u to v
                        minCycle = Math.min(minCycle, cycleLen);
                    }
                }
            }
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}