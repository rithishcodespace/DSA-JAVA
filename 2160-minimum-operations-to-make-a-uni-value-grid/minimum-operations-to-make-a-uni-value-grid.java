class Solution {
    public int minOperations(int[][] grid, int x) {
        int operations = 0;
        // find the median element
        List<Integer> elements = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                elements.add(grid[i][j]);
            }
        }
        Collections.sort(elements);
        int midIdx = (0+(elements.size()-1))/2;
        int num = elements.get(midIdx);

        // try to make every element as num
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == num)continue;

                int diff = Math.abs(grid[i][j]-num);
                int rem = diff % x;

                if(rem != 0){
                    return -1;
                }

                operations += (rem == 0) ? diff/x : 0;
            }
        }

        return operations;
    }
}