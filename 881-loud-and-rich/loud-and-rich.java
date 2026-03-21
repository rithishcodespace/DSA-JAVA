// intuition
 // - If A is richer than B,
 // - then whatever A knows (quietest rich person)…
 // - B can also use that info
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // create adj_list
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<quiet.length;i++)adj_list.add(new ArrayList<>());
        for(int i=0;i<richer.length;i++){
            int u = richer[i][0];
            int v = richer[i][1];

            adj_list.get(u).add(v);
        }
        // create ans (quiet person among richer persons)
        int[] ans = new int[quiet.length];
        for(int i=0;i<ans.length;i++)ans[i] = i;
        // toposort
        topo_sort(adj_list, quiet, ans);
        return ans;
    }
    public void topo_sort(List<List<Integer>> adj_list, int[] quiet, int[] ans){
        // find indegree (to start from richest person)
        int[] in_degree = new int[quiet.length];
        for(int i=0;i<adj_list.size();i++){
            int u = i;
            for(int j=0;j<adj_list.get(u).size();j++){
                int v = adj_list.get(u).get(j);
                in_degree[v]++;
            }
        }
        // add richest people to queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<quiet.length;i++){
            if(in_degree[i] == 0){
                queue.add(i);
            }
        }
        // start toposort
        while(!queue.isEmpty()){
            int u = queue.poll(); // rich
            // get poors
            for(int i=0;i<adj_list.get(u).size();i++){
                int v = adj_list.get(u).get(i);

                if(quiet[ans[u]] < quiet[ans[v]]){
                    ans[v] = ans[u];
                }

                in_degree[v]--;

                if(in_degree[v] == 0){
                    queue.add(v);
                }
            }
        }
    }
}