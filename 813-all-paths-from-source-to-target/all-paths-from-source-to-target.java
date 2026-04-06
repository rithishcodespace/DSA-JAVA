class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        path.add(0); 
        dfs(graph, ans, path, 0);
        
        return ans;
    }

    public void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> path, int node) {
        
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, ans, path, next);
            path.remove(path.size() - 1); 
        }
    }
}