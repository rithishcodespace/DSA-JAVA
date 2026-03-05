class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost_array = new int[n];
        Arrays.fill(cost_array,Integer.MAX_VALUE);
        cost_array[src] = 0;
        // create adj_list
        List<List<Pair>> adj_list = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj_list.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int source = flights[i][0];
            int destination = flights[i][1];
            int cost = flights[i][2];

            adj_list.get(source).add(new Pair(destination, cost));
        } 
        // use stops for priority(since edge weight became same, use queue)
        dijkstra(cost_array,adj_list,src,dst,k);
        return (cost_array[dst] == Integer.MAX_VALUE) ? -1 : cost_array[dst];
    }
    public void dijkstra(int[] cost_array, List<List<Pair>> adj_list, int src, int det, int k){
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(0,src,0));

        while(!queue.isEmpty()){
            Element element = queue.poll();
            int node = element.node;
            int stops = element.stops;
            int cost = element.cost;

            if(element.stops > k)continue;

            for(int i=0;i<adj_list.get(node).size();i++){
                Element newElement = new Element(stops+1,adj_list.get(node).get(i).destination,cost+adj_list.get(node).get(i).cost);

                if(cost_array[adj_list.get(node).get(i).destination] > cost+adj_list.get(node).get(i).cost){
                    cost_array[adj_list.get(node).get(i).destination] = cost+adj_list.get(node).get(i).cost;
                    queue.add(newElement);
                }
            }
        }
    }
}
class Element{
    int stops;
    int node;
    int cost;

    Element(int stops, int node, int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}
class Pair{
    int destination;
    int cost;

    Pair(int destination, int cost){
        this.destination = destination;
        this.cost = cost;
    }
}