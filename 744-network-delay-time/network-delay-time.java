class Solution {

    static class Pair{
        int node;
        int weight;

        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;

        // build adj_list
        List<List<Pair>> adj_list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj_list.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj_list.get(u).add(new Pair(v,w));
        }

        dijkstra(adj_list, distance, k);
        
        int ans = 0;

        for(int i=1;i<=n;i++){
            if(distance[i] == Integer.MAX_VALUE)return -1;
            ans = Math.max(ans, distance[i]);
        }

        return ans;

    }

    public void dijkstra(List<List<Pair>> adj_list, int[] distance, int k){

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> {
            if(a.weight == b.weight){
                return a.node-b.node;
            }
            return a.weight-b.weight;
        });
        minHeap.add(new Pair(k,0));

        while(!minHeap.isEmpty()){
            Pair pair = minHeap.poll();
            int node = pair.node;
            int weight = pair.weight;

            // eleminate duplicates
            if(distance[node] < weight)continue;

            for(int i=0;i<adj_list.get(node).size();i++){
                int dist = weight + adj_list.get(node).get(i).weight;
                if(distance[adj_list.get(node).get(i).node] > dist){
                    distance[adj_list.get(node).get(i).node] = dist;
                    minHeap.add(new Pair(adj_list.get(node).get(i).node,dist));
                }
            }
        }
    }
}