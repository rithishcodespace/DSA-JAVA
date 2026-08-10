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
            int u = edge[1];
            int v = edge[0];

            adj.get(u).add(v);
        }

        // dfs
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj, stack);
            }
        }

        if(stack.size() != numCourses)return new int[]{};

        int idx = 0;
        int[] ans = new int[numCourses];

        while(!stack.isEmpty()){
            ans[idx++] = stack.pop();
        }

        return ans;
    }
    public void dfs(int u, int[] visited, List<List<Integer>> adj, Stack<Integer> stack){
        visited[u] = 1;

        for(int v : adj.get(u)){
            if(visited[v] == 0){
                dfs(v, visited, adj, stack);
            }
            else if(visited[v] == 1)return;
        }

        visited[u] = 2;
        stack.add(u);
    }
}