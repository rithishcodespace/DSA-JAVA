// we are just checking is it a DAG via toposort (kahn)

// toposort.size() == n ? true : false;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adj list + indegree

        int[] in_degree = new int[numCourses];
        List<List<Integer>> adj_list = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            in_degree[v]++;

            adj_list.get(u).add(v);
        }

        // kahn topo sort 

        List<Integer> topo = new ArrayList<>();
        bfs(in_degree, adj_list, topo);

        return (topo.size() == numCourses) ? true : false;
    }
    public void bfs(int[] in_degree, List<List<Integer>> adj_list, List<Integer> topo){
        // insert node with 0 indegree
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<adj_list.size();i++){
            if(in_degree[i] == 0){
                queue.add(i);
            }
        }

        // bfs
        while(!queue.isEmpty()){
            int u = queue.poll();

            for(int v : adj_list.get(u)){
                in_degree[v]--;

                if(in_degree[v] == 0)queue.add(v);
            }

            topo.add(u);
        }
    }
}