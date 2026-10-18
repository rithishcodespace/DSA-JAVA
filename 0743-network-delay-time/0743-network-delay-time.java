// dijkstra - return highest of all shortest times 

class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        int[] times = new int[n+1];
        Arrays.fill(times, Integer.MAX_VALUE);

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });

        // create adj list
        List<List<Element>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], time = edge[2];

            adj.get(u).add(new Element(v, time));
        }

        // dijkstra
        times[k] = 0;
        minHeap.add(new Element(k, 0));

        while(!minHeap.isEmpty()){
            Element e = minHeap.poll();
            int u = e.node, time = e.time;

            // outdated time
            if(time > times[u])continue;

            for(int i=0;i<adj.get(u).size();i++){
                int v = adj.get(u).get(i).node;
                int newTime = adj.get(u).get(i).time + time;

                if(newTime < times[v]){
                    times[v] = newTime;
                    minHeap.add(new Element(v, newTime));
                }
            }
        }

        // find the max time
        int max = -1;

        for(int i=1;i<times.length;i++){
            max = Math.max(max, times[i]);
        }

        return max != Integer.MAX_VALUE ? max : -1;
    }
}
class Element{
    int node, time;

    Element(int node, int time){
        this.node = node;
        this.time = time;
    }
}