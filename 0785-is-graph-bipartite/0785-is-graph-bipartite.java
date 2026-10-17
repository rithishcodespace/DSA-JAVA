// bfs - each level should be of different color
// dfs - parent and child should not be of same color

// 0 - not visited, 1 - green, 2 - red

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(color[i] == 0){
                if(!dfs(i, color, graph))return false;
            }
        }

        return true;
    }
    public boolean dfs(int u, int[] color, int[][] graph){
        for(int v : graph[u]){
            if(color[v] == 0){
                int prevColor = color[u], currentColor = -1;

                if(prevColor == 0)currentColor = 1;
                else currentColor = prevColor == 1 ? 2 : 1;

                color[v] = currentColor;
                if(!dfs(v, color, graph)){
                    return false;
                }
            }
            else if(color[v] == color[u]){
                return false; // already child colored
            }
        }

        return true;
    }
}