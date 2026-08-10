// recursive topo sort
// 0 → not visited
// 1 → currently visiting
// 2 → completely finished

class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
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
                if(dfs(i, visited, adj)){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean dfs(int u, int[] visited, List<List<Integer>> adj){
        visited[u] = 1;

        for(int v : adj.get(u)){
            if(visited[v] == 0){
                if(dfs(v, visited, adj))return true;
            }
            else if(visited[v] == 1)return true;
        }

        visited[u] = 2;

        return false;
    }
}