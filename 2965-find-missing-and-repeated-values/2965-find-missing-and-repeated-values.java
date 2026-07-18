// brute force

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int key = 0, miss = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                map.put(grid[i][j], map.getOrDefault(grid[i][j],0)+1);
                if(map.get(grid[i][j]) > 1)key = grid[i][j];
            }
        }

        for(int i=1;i<=grid.length*grid.length;i++){
            if(!map.containsKey(i))miss = i;
        }

        return new int[]{key,miss};
    }
}