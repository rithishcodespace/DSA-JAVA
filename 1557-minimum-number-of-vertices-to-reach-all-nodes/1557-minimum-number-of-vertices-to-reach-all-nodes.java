// count edges with indegree as 0

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);

            indegree[v]++;
        }

        for(int u=0;u<n;u++){
            if(indegree[u] == 0)ans.add(u);
        }

        return ans;
    }
}