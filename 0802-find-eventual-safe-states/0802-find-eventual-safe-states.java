// reverse engineer the question, instead of trying to reach a terminal node, start from terminal node and go backwords 
// all nodes in this part will be a safe node (which do not start a cycle)

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // reverse the edge direction using adj list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<graph.length;i++)adj.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }

        // toposort will find the linear path reaching terminal nodes + automatically leaves the nodes creating cycles
        List<Integer> topo = new ArrayList<>();
        toposort(adj, topo);

        Collections.sort(topo);
        return topo;
    }
    // kahn algo
    public void toposort(List<List<Integer>> adj, List<Integer> topo){
        int[] indegree = new int[adj.size()];

        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                indegree[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[adj.size()];

        // insert nodes with indegree as 0
        for(int i=0;i<adj.size();i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            topo.add(u);

            for(int v : adj.get(u)){
                indegree[v]--;

                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }
    }
}