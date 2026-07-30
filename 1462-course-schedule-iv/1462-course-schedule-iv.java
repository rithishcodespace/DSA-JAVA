// dfs toposort - visit neighbors first

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        boolean[][] reach = new boolean[numCourses][numCourses];
        // create adjlist
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
        }

        // topo sort
        int[] visited = new int[numCourses];
        List<Integer> topo = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0){
                dfs(i, visited, stack, adj);
            }
        }


        while(!stack.isEmpty()){
            topo.add(stack.pop());
        }

        // dp 
        for(int u : topo){
            for(int v : adj.get(u)){
                reach[u][v] = true;

                // i is a prerequisite of u
                // then i is a prerequisite of v

                for(int i=0;i<numCourses;i++){
                    if(reach[i][u]){
                        reach[i][v] = true;
                    }
                }
            }
        }

        // answer queries
        for(int[] q : queries){
            ans.add(reach[q[0]][q[1]]);
        }

        return ans;
    }
    public void dfs(int node, int[] visited, Stack<Integer> stack, List<List<Integer>> adj){
        visited[node] = 1;

        for(int neigh : adj.get(node)){
            if(visited[neigh] == 0){
                dfs(neigh, visited, stack, adj);
            }
        }

        stack.push(node);
    }
}