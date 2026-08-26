// bfs - each level different color
// dfs - parent and child are different color

// 0 - no visited, 1 - green, 2 - red

class Solution { 
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for(int i=0;i<graph.length;i++){ // since graph nodes might be disconnected
            if(colors[i] == 0){
                if(!dfs(i, 0, graph, colors)){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean dfs(int u, int prevColor, int[][] graph, int[] colors){
        if(prevColor == 0 || prevColor == 2)colors[u] = 1; // green
        else if(prevColor == 1)colors[u] = 2;

        for(int i=0;i<graph[u].length;i++){
            int v = graph[u][i];

            if(colors[v] == 0){
                if(!dfs(v, colors[u], graph, colors)){
                    return false;
                }
            }
            else if(colors[v] == colors[u]){
                return false;
            }
        }

        return true;
    }
}