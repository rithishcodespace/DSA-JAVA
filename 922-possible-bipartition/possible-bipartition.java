class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // create adj_list
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj_list.add(new ArrayList<>());
        }
        for(int i=0;i<dislikes.length;i++){
            adj_list.get(dislikes[i][0]).add(dislikes[i][1]);
            adj_list.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        // color adj graph
        int[] color = new int[n+1]; // 0 -> not colored, 1 -> blue color, -1 -> red color

        for(int i=1;i<=n;i++){
            if(color[i] == 0){
                if(!bfs(adj_list,color,i))return false;
            }
        }

        return true;
    }
    public boolean bfs(List<List<Integer>> adj_list, int[] color, int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;

        while(!queue.isEmpty()){
            node = queue.poll();
            for(int i=0;i<adj_list.get(node).size();i++){
                int neighbour = adj_list.get(node).get(i);
                if(color[neighbour] == 0){
                    color[neighbour] = -color[node];
                    queue.add(neighbour);
                }
                else if(color[node] == color[neighbour]){
                    return false;
                }
            }
        }

        return true;
    }
}