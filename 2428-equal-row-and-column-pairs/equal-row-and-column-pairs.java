class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        // row
        for(int i=0;i<grid.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<grid[0].length;j++){
                sb.append(String.valueOf(grid[i][j])).append(",");
            }
            String key = sb.toString();
            map1.put(key,map1.getOrDefault(key,0)+1);
        }
        // col
        for(int j=0;j<grid[0].length;j++){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<grid.length;i++){
                sb.append(String.valueOf(grid[i][j])).append(",");
            }
            String key = sb.toString();
            map2.put(key,map2.getOrDefault(key,0)+1);
        }
        // find keys with freq greater than 1
        int cnt = 0;
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                cnt += map1.get(key) * map2.get(key);  
            }
        }
        return cnt;
    }
}