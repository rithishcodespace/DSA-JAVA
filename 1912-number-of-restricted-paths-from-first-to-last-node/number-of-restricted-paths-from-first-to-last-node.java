class Solution {
    int[] dp;
    int MOD = 1000000007;
    public int countRestrictedPaths(int n, int[][] edges) {
        // find shortest distance from each node to last node
        List<List<Node>> adj_list = new ArrayList<>();
        for(int i=0;i<n+1;i++)adj_list.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj_list.get(u).add(new Node(v,w));
            adj_list.get(v).add(new Node(u,w));
        }        

        // dijkstra
        int[] distance = new int[n+1];
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> a.w - b.w);
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        distance[n] = 0;

        minHeap.add(new Node(n,0));
        while(!minHeap.isEmpty()){
            Node cell = minHeap.poll();
            int u = cell.v;
            int d_u = cell.w;

            if(distance[u] < d_u)continue;

            for(int i=0;i<adj_list.get(u).size();i++){
                int v = adj_list.get(u).get(i).v;
                int w = adj_list.get(u).get(i).w;
                int new_dist = d_u+w;
                if(distance[v] > new_dist){
                    distance[v] = new_dist;
                    minHeap.add(new Node(v,new_dist));
                }
            }
        }

        // start from 1, move to nodes only with lesser distance to n than me
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(1,n,adj_list,distance);
    }
    public int dfs(int u, int n, List<List<Node>> adj_list, int[] distance){
        if(u == n){
            return 1;
        }

        if(dp[u] != -1)return dp[u];

        int count = 0;

        for(int i=0;i<adj_list.get(u).size();i++){
            int v = adj_list.get(u).get(i).v;

            if(distance[v] < distance[u]){ // lesser distance than me
                count = (count + dfs(v, n, adj_list, distance)) % MOD;
            }
        }

        return dp[u] = count;
    }
}
class Node{
    int v;
    int w;

    Node(int v, int w){
        this.v = v;
        this.w = w;
    }
}