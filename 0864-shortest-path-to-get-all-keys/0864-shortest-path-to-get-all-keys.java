class Solution {
    public int shortestPathAllKeys(String[] s) {
        // convert string to grid
        char[][] grid = new char[s.length][];

        for (int i = 0; i < s.length; i++) {
            grid[i] = s[i].toCharArray();
        }

        // bfs
        int keyCount = 0;
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        
        // find starting point
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '@'){
                    q.add(new int[]{i,j,0,0});
                }
                else if(grid[i][j] >= 'a' && grid[i][j] <= 'z'){
                    keyCount++;
                }
            }
        }

        int[][][] visited = new int[grid.length][grid[0].length][1 << keyCount];
        int allkeys = (1 << keyCount)-1;

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int[] d : dir){
                int nr = node[0]+d[0];
                int nc = node[1]+d[1];
                int keys = node[2];


                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] != '#'){
                    
                    if(grid[nr][nc] >= 'a' && grid[nr][nc] <= 'z'){
                        keys |= (1 << (grid[nr][nc]-'a'));

                        if(keys == allkeys)return node[3]+1;
                    }

                    if(visited[nr][nc][keys] == 1)continue;

                    if(grid[nr][nc] >= 'A' && grid[nr][nc] <= 'Z'){
                        if((keys & (1 << (grid[nr][nc] - 'A'))) != 0){ // got a key
                            visited[nr][nc][keys]=1;
                            q.add(new int[]{nr, nc, keys, node[3]+1});
                        }
                    }
                    else{
                        visited[nr][nc][keys]=1;
                        q.add(new int[]{nr, nc, keys, node[3]+1});
                    }
                }
            }
        }

        return -1;
    }
}