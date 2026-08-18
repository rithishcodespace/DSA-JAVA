class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int assigned = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int x : s){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(int x : g){
            Integer key = map.ceilingKey(x); // if not present, returns null

            if(key != null){
                assigned++;

                map.put(key, map.get(key)-1);
                if(map.get(key) == 0){
                    map.remove(key);
                }
            }
        }

        return assigned;
    }
}