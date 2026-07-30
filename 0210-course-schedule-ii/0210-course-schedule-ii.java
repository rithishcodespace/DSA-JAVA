// ques: Can I arrange all the courses so every prerequisite comes first?
// kahn toposort algo

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        // build ans array

        if(topo.size() != numCourses)return new int[]{};

        int idx = 0;
        int[] ans = new int[topo.size()];
        for(int x : topo){
            ans[idx++] = x;
        }

        return ans;
    }
}