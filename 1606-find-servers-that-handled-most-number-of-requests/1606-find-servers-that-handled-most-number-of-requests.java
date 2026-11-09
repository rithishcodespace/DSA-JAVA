class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int timer = 0, maxReq = 0, maxServer = 0;

        TreeSet<Integer> set = new TreeSet<>(); // maintains available servers
        PriorityQueue<Request> pq = new PriorityQueue<>((a,b) -> a.time - b.time); // sorted via finishing time
        HashMap<Integer,Integer> hmap = new HashMap<>(); // to track, server - no.of req

        // intially all servers are available
        for(int i=0;i<k;i++){
            set.add(i);
        }

        // process each req
        for(int i=0;i<arrival.length;i++){
            // release the completed servers
            while (!pq.isEmpty() && pq.peek().time <= arrival[i]) {
                set.add(pq.poll().server);
            }

            int expectedServer = i%k;

            // pick either it or next one to it
            int server = findServer(set, expectedServer);

            // if all servers are busy
            if(server == -1)continue;

            // track no.of req
            hmap.put(server, hmap.getOrDefault(server,0)+1);
            if(maxReq < hmap.get(server)){
                maxReq = hmap.get(server);
                maxServer = server;
            }

            // remove the choosed server
            set.remove(server);

            // assign work to the server
            pq.add(new Request(server, arrival[i]+load[i]));

            timer++;
        }

        // return a list of maxReq servers
        List<Integer> list = new ArrayList<>();
        for(int key : hmap.keySet()){
            if(hmap.get(key) == maxReq)list.add(key);
        }

        return list;
    }
    public int findServer(TreeSet<Integer> set, int expectedServer){
        if(set.size() == 0)return -1;

        int server = -1;

        for(int s : set){
            if(s >= expectedServer){
                return s;
            }
        }

        // if there is no one after expected, pick before it
        if(set.first() < expectedServer)return set.first();

        return server;
    }
}
class Request{
    int server, time;

    Request(int server, int time){
        this.server = server;
        this.time = time;
    }
}