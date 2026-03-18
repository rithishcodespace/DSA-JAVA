class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        int[] visited = new int[n+1];
        // create adj_list
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj_list.add(new ArrayList<>());
        }
        for(int i=0;i<paths.length;i++){
            int key = paths[i][0];
            int val = paths[i][1];

            adj_list.get(key).add(val);
            adj_list.get(val).add(key);
        }
        for(int i=1;i<=n;i++){
            if(visited[i] == 0){
                dfs(adj_list,visited,i,ans);
            }
        }
        return ans;
    }
    public void dfs(List<List<Integer>> adj_list, int[] visited, int node, int[] ans){
        visited[node] = 1;
        boolean[] used = new boolean[5];
        // mark used plants by neighbours
        for(int neigh : adj_list.get(node)){
            if(ans[neigh-1] != 0){
                used[ans[neigh-1]] = true;
            }
        }
        // assign first unsed one
        for(int i=1;i<5;i++){
            if(!used[i]){
                ans[node-1] = i;
                break;
            }
        }

        for(int i=0;i<adj_list.get(node).size();i++){
            if(visited[adj_list.get(node).get(i)] == 0){
                dfs(adj_list, visited, adj_list.get(node).get(i), ans);
            }
        }
    }
}

class Garden{
    int val;
    int plant;

    Garden(int val, int plant){
        this.val = val;
        this.plant = plant;
    }
}