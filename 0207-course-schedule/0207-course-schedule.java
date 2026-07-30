// ques: Can I arrange all the courses so every prerequisite comes first?
// kahn toposort algo

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> topo = new ArrayList<>();

        // create adjlist + indegree
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);

            indegree[u]++;
        }

        // push nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        // remove their childs
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);

            for(int neigh : adj.get(node)){
                indegree[neigh]--;

                if(indegree[neigh] == 0){
                    queue.add(neigh);
                }
            }
        }

        // checks if there is a cycle and a correct learning order exists ?
        return topo.size() == numCourses ? true : false;
    }
}