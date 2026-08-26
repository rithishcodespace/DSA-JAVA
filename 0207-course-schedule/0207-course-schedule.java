// we are just checking is it a DAG via toposort

// 0 -> not visited
// 1 -> currently visiting
// 2 -> visited

// If we encounter a cycle, we stop

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adj list

        List<List<Integer>> adj_list = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj_list.get(u).add(v);
        }

        // recursive topo sort

        int[] visited = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, adj_list, visited)){
                return false;
            }
        }

        return true;
    }
    public boolean dfs(int u, List<List<Integer>> adj_list, int[] visited){
        visited[u] = 1;

        for(int v : adj_list.get(u)){
            if(visited[v] == 0){
                if(!dfs(v, adj_list, visited)){
                    return false;
                }
            }
            else if(visited[v] == 1){
                return false;
            }
        }
        
        visited[u] = 2;

        return true;
    }
}