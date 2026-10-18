// each level is a flight, dont go beyond k level

// intermediate cities do not include src and dst, so we use k+1, not exact k

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n]; // also act as visited
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        Queue<Element> q = new LinkedList<>();
        q.add(new Element(src, 0, 0));

        // adj list
        List<List<Element>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] edge : flights){
            int u = edge[0], v = edge[1], cost = edge[2];
            adj.get(u).add(new Element(v, cost, 0));
        }

        while(!q.isEmpty()){
            Element e = q.poll();
            int u = e.node, price = e.price, stops = e.stops;

            if(stops > k)continue; // dont spread further

            for(int i=0;i<adj.get(u).size();i++){
                int newCost = price + adj.get(u).get(i).price;
                if(newCost < costs[adj.get(u).get(i).node]){
                    costs[adj.get(u).get(i).node] = newCost;
                    q.add(new Element(adj.get(u).get(i).node, newCost, stops+1));
                }
            }
        }

        return costs[dst] != Integer.MAX_VALUE ? costs[dst] : -1;
    }
}
class Element{
    int node, price, stops;

    Element(int node, int price, int stops){
        this.node = node;
        this.price = price;
        this.stops = stops;
    }
}