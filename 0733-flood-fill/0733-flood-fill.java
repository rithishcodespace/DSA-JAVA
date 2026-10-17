// dfs or bfs

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];

        // Important edge case
        if(startColor == color) {
            return image;
        }

        int[][] visited = new int[image.length][image[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        visited[sr][sc] = 1;
        image[sr][sc] = color;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for(int[] d : dir){
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length){
                    if(image[nr][nc] == startColor){
                        image[nr][nc] = color;
                        visited[nr][nc] = 1;

                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return image;
    }
}