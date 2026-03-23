// traverse through the matrix, when you find a 1, start dfs and mark the entire island as 2
// now put all 2(island 1) into the queue and do multi-source bfs
// when you find 1(island 2) stop
// ans will be min of distance from each source

class Solution {
    int min = Integer.MAX_VALUE;
    Queue<Node> queue = new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        // find '1' -> mark entire island 1
        for(int i=0;i<grid.length;i++){
            boolean found = false;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
            if(found)break;
        }
        bfs(grid);
        return min;
    }
    // mark the island 1 as 2
    // push the island 1's Nodes into queue for multisource bfs
    public void dfs(int[][] grid, int r, int c){
        grid[r][c] = 2;
        queue.add(new Node(r,c,0));

        // up
        if(r-1 >= 0 && grid[r-1][c] == 1){
            dfs(grid, r-1, c);
        }
        // down
        if(r+1 < grid.length && grid[r+1][c] == 1){
            dfs(grid, r+1, c);
        }
        // left
        if(c-1 >= 0 && grid[r][c-1] == 1){
            dfs(grid, r, c-1);
        }
        // right
        if(c+1 < grid[0].length && grid[r][c+1] == 1){
            dfs(grid, r, c+1);
        }
    }
    // multisource bfs
    public void bfs(int[][] grid){
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int r = node.r;
            int c = node.c;
            int d = node.distance;

            // up
            if(r-1 >= 0){
                if(grid[r-1][c] == 0){
                    grid[r-1][c] = 3;
                    queue.add(new Node(r-1,c,d+1));
                }
                else if(grid[r-1][c] == 1){
                    min = Math.min(min,d);
                    return;
                }
            }
            // down
            if(r+1 < grid.length){
                if(grid[r+1][c] == 0){
                    grid[r+1][c] = 3;
                    queue.add(new Node(r+1,c,d+1));
                }
                else if(grid[r+1][c] == 1){
                    min = Math.min(min,d);
                    return;
                }
            }
            // left
            if(c-1 >= 0){
                if(grid[r][c-1] == 0){
                    grid[r][c-1] = 3;
                    queue.add(new Node(r,c-1,d+1));
                }
                else if(grid[r][c-1] == 1){
                    min = Math.min(min,d);
                    return;
                }
            }
            // right
            if(c+1 < grid[0].length){
                if(grid[r][c+1] == 0){
                    grid[r][c+1] = 3;
                    queue.add(new Node(r,c+1,d+1));
                }
                else if(grid[r][c+1] == 1){
                    min = Math.min(min,d);
                    return;
                }
            }
        }
    }
}

class Node{
    int r;
    int c;
    int distance;

    Node(int r, int c, int distance){
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}