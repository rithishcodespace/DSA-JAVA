class Solution {

    int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    List<List<Integer>> points = new ArrayList<>(); 

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] atlantic = new int[heights.length][heights[0].length];
        int[][] pacific = new int[heights.length][heights[0].length];

        // from pacific
        for(int i=0;i<heights.length;i++){
            dfs(i, 0, heights, pacific);
        }
        for(int i=0;i<heights[0].length;i++){
            dfs(0, i, heights, pacific);
        }
        // from atlantic
        for(int i=0;i<heights.length;i++){
            dfs(i, heights[0].length-1, heights, atlantic);
        }
        for(int i=0;i<heights[0].length;i++){
            dfs(heights.length-1, i, heights, atlantic);
        }

        // count cells with both altantic and pacific
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(atlantic[i][j] == 1 && pacific[i][j] == 1){
                    points.add(Arrays.asList(i,j));
                }
            }
        }

        return points;
    }
    public void dfs(int r, int c, int[][] heights, int[][] visited){
        visited[r][c] = 1;

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && heights[r][c] <= heights[nr][nc] && visited[nr][nc] == 0){
                dfs(nr, nc, heights, visited);
            }
        }        
    }
}