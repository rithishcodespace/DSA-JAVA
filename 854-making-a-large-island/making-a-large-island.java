// connect all 1's in the question as a single component via dsu

class Solution {

    int[] parent;
    int[] size;
    int[] visited;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public int largestIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        parent = new int[grid.length*grid[0].length];
        size = new int[grid.length*grid[0].length];
        visited = new int[grid.length*grid[0].length];

        for(int i=0;i<grid.length*grid[0].length;i++){
            parent[i] = i;
            size[i] = 1;
        }

        // connect components
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int cell = getCell(i,j,grid[0].length);
                if(grid[i][j] == 1 && visited[cell] == 0){
                    makeComponent(i,j,grid);
                }
            }
        }

        // check making each 0 -> 1
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                HashSet<Integer> set = new HashSet<>();
                int sum = 1;
                if(grid[i][j] == 0){ // collect four direction components size
                    for(int[] d : dir){
                        int nr = i + d[0];
                        int nc = j + d[1];

                        if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){

                            if(grid[nr][nc] == 1){
                                int cell = getCell(nr, nc, grid[0].length);
                                int p_cell = findParent(cell);
                                set.add(p_cell);
                            }
                        }

                    }
                    for(int p : set){
                        sum += size[p];
                    }
                    max = Math.max(max,sum);
                }
            }
        }

        return max == Integer.MIN_VALUE ? grid.length * grid[0].length : max;
    }

    public void makeComponent(int r, int c, int[][] grid){
        int u = getCell(r,c,grid[0].length);
        visited[u] = 1;
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                int v = getCell(nr,nc,grid[0].length);
                if(grid[nr][nc] == 1 && visited[v] == 0){

                    union(u,v);
                    
                    makeComponent(nr,nc,grid);
                }
            }
        }
    }

    public int getCell(int row, int col, int cols){
        return (row*cols)+col;
    }

    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv)return;

        int u_size = size[pu];
        int v_size = size[pv];

        if(u_size > v_size){
            size[pu] += size[pv];
            parent[pv] = pu;
        }
        else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }

    public int findParent(int node){
        if(node != parent[node]){
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }
}