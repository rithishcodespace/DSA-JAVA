// test case 1
// rowCondition -> 1 (row 0) 3 (row 1) 2 (row 2)
// colCondition -> 3 (col 0) 2 (col 1) 1 (col 2)

// now each val (1 to k) is mapped to a row and col, eg: 1 -> (0,2)

// to detect cycles
    // 0 = unvisited
    // 1 = visiting
    // 2 = finished

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(i+1, new int[]{0,0});
        }

        // create adjlist for row and col
        List<List<Integer>> adjR = new ArrayList<>();
        List<List<Integer>> adjC = new ArrayList<>();

        for(int i=0;i<=k;i++){
            adjR.add(new ArrayList<>());
            adjC.add(new ArrayList<>());
        }

        for(int i=0;i<rowConditions.length;i++){
            int u = rowConditions[i][0];
            int v = rowConditions[i][1];

            adjR.get(u).add(v);
        }
        for(int i=0;i<colConditions.length;i++){
            int u = colConditions[i][0];
            int v = colConditions[i][1];

            adjC.get(u).add(v);
        }

        // topo sort for row
        int[] visitedR = new int[k+1];
        List<Integer> topoR = new ArrayList<>();
        Stack<Integer> row = new Stack<>();
        
        for(int i=1;i<=k;i++){
            if(visitedR[i]==0){
                if(!dfs(i,row,visitedR,adjR)){
                    return new int[0][0];
                }
            }
        }

        int idx = 0;
        while(!row.isEmpty()){
            map.get(row.peek())[0] = idx++;
            topoR.add(row.pop());
        }

        // topo sort for col
        int[] visitedC = new int[k+1];
        List<Integer> topoC = new ArrayList<>();
        Stack<Integer> col = new Stack<>();

        for(int i=1;i<=k;i++){
            if(visitedC[i]==0){
                if(!dfs(i,col,visitedC,adjC)){
                    return new int[0][0];
                }
            }
        }
        
        // create matrix

        idx=0;
        while(!col.isEmpty()){
            map.get(col.peek())[1] = idx++;
            topoC.add(col.pop());
        }

        // plot these in the matrix
        for(int key : map.keySet()){
            int r = map.get(key)[0];
            int c = map.get(key)[1];

            matrix[r][c] = key;
        }

        return matrix;
    }
    public boolean dfs(int node, Stack<Integer> stack, int[] visited, List<List<Integer>> adj){
        visited[node] = 1;

        for(int neigh : adj.get(node)){
            if(visited[neigh] == 0){
                if(!dfs(neigh, stack, visited, adj)){
                    return false;
                }
            }
            else if(visited[neigh] == 1)return false;
        }

        stack.push(node);
        visited[node] = 2;

        return true;
    }
}