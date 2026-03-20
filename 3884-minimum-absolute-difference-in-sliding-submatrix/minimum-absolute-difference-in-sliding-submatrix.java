class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] matrix = new int[m-k+1][n-k+1];

        for(int i=0;i<grid.length-k+1;i++){
            for(int j=0;j<grid[0].length-k+1;j++){
                solve(i,j,k,matrix,grid);
            }
        }

        return matrix;
    }

    public void solve(int r, int c, int k, int[][] matrix, int[][] grid){
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        // visit k rows and k cols
        for(int i=r;i<r+k;i++){
            for(int j=c;j<c+k;j++){
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);
        int prev = list.get(0);
        for(int i=1;i<list.size();i++){
            int curr = list.get(i);
            int diff = Math.abs(curr-prev);
            if(diff != 0){
                min = Math.min(min,diff);
            }
            prev = curr;
        }

        matrix[r][c] = (min == Integer.MAX_VALUE) ? 0 : min;
    }
}