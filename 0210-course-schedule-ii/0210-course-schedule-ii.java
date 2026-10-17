// ques: Can I arrange all the courses so every prerequisite comes first?
// dfs topo sort

class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites){
        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();

        // create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int[] edge : prerequisites){
            int u = edge[1], v = edge[0];

            adj.get(u).add(v);
        }

        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0){
                dfs(i, visited, adj, stack);
            }
        }

        if(stack.size() != numCourses)return new int[]{};

        int idx=0;
        int[] res = new int[numCourses];

        while(!stack.isEmpty()){
            res[idx++] = stack.pop();
        }

        return res;
    }
    public void dfs(int u, int[] visited, List<List<Integer>> adj, Stack<Integer> stack){
        visited[u] = 1;

        for(int v : adj.get(u)){
            if(visited[v] == 0){
                dfs(v, visited, adj, stack);
            }
            else if(visited[v] == 1)return; // this path not possible (cycle), so stop this path and visit other paths
        }

        visited[u] = 2;
        stack.add(u);
    }

}