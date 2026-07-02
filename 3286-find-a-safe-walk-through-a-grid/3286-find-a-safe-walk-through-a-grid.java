class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        // acts as visited array (if you visited the cell again, with greater health allowed)
        int[][] best = new int[grid.size()][grid.get(0).size()];

        for(int i = 0; i < grid.size(); i++){
            Arrays.fill(best[i], -1);
        }

        if(grid.get(0).get(0) == 1)health--;

        return dfs(0, 0, health, grid, best);
    }

    public boolean dfs(int r, int c, int health, List<List<Integer>> grid, int[][] best){
        if (best[r][c] != -1 && best[r][c] >= health || health < 1) return false;

        if (r == grid.size() - 1 && c == grid.get(0).size() - 1)return true;

        // memoize health
        best[r][c] = health;

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int[] dir : directions) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;

            if(nr >= 0 && nr < best.length && nc >= 0 && nc < best[0].length){
                if(grid.get(nr).get(nc) == 1){
                    if(dfs(nr, nc, health - 1, grid, best)){
                        return true;
                    }
                }
                else{
                    if(dfs(nr, nc, health, grid, best)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}