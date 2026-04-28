class Solution {
    public int[][] findFarmland(int[][] land) {
        // find the forests
        int[][] visited = new int[land.length][land[0].length];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j] == 1 && visited[i][j] == 0){
                    int[] idx = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
                    dfs(i, j, land, visited, idx);
                    list.add(Arrays.asList(idx[0],idx[1],idx[2],idx[3]));
                }
            }
        }
        // convert list to array
        if(list.size() == 0){
            int[][] ans = new int[0][0];
            return ans;
        }

        int[][] ans = new int[list.size()][list.get(0).size()];
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(0).size();j++){
                ans[i][j] = list.get(i).get(j);
            }
        }

        return ans;
    }
    public void dfs(int r, int c, int[][] land, int[][] visited, int[] idx){
        visited[r][c] = 1;

        idx[0] = Math.min(idx[0],r);
        idx[1] = Math.min(idx[1],c);

        idx[2] = Math.max(idx[2],r);
        idx[3] = Math.max(idx[3],c);

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length){
                if(land[nr][nc] == 1 && visited[nr][nc] == 0){
                    dfs(nr, nc, land, visited, idx);
                }
            }

        }
    }
}