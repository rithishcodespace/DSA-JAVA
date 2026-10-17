// kahn algo - based on indegree
// true if all vertices can be arranged else false

// return stack.size() == n ? true : false
// Since queue becomes empty if cycle exists before visiting all nodes

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        // create adj list and indegree
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());

        for(int[] edge : prerequisites){
            int v = edge[0], u = edge[1];
            indegree[v]++;

            adj.get(u).add(v);
        }

        // kahn algo
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        // insert nodes with 0 indegree
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0)q.add(i);
        }

        while(!q.isEmpty()){
            int u = q.poll();
            stack.push(u);

            for(int v : adj.get(u)){
                indegree[v]--;

                if(indegree[v] == 0)q.add(v);
            }
        }

        return stack.size() == numCourses ? true : false;
    }
}