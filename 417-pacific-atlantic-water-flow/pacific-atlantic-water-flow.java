class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];

        // dfs from pacific ocean
        for(int i=0;i<heights.length;i++){
            dfs(i, 0, heights, pacific);
        }
        for(int i=0;i<heights[0].length;i++){
            dfs(0, i, heights, pacific);
        }
        // dfs from atlantic ocean
        for(int i=0;i<heights.length;i++){
            dfs(i, heights[0].length-1, heights, atlantic);
        }
        for(int i=0;i<heights[0].length;i++){
            dfs(heights.length-1, i, heights, atlantic);
        }

        // count cells with 2
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    list.add(Arrays.asList(i,j));
                }
            }
        }

        return list;
    }
    
    public void dfs(int r, int c, int[][] heights, int[][] visited){
        visited[r][c]=1;

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length){
                if(heights[nr][nc] >= heights[r][c] && visited[nr][nc] == 0){
                    dfs(nr, nc, heights, visited);
                }
            }
        }
    }
}