class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itinerary = new ArrayList<>();

        // adj list
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> ticket : tickets){
            String from = ticket.get(0), to = ticket.get(1);

            if(!adj.containsKey(from)){
                adj.put(from, new PriorityQueue<>());
            }

            adj.get(from).add(to);
        }

        // DFS from JFK
        dfs("JFK", adj, itinerary);

        return itinerary;
    }

    public void dfs(String from, HashMap<String, PriorityQueue<String>> adj, List<String> itinerary){

        // traverse all outgoing tickets in lexicographical order
        while(adj.containsKey(from) && !adj.get(from).isEmpty()){
            String to = adj.get(from).poll(); // visited (we don't backtrack)
            dfs(to, adj, itinerary);
        }

        // add airport after processing all its tickets (0'th INDEX)
        itinerary.add(0, from);
    }
}
