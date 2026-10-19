// if points are on same row or same cell, group them as components
// leave one point per component, remove others

class Solution {

    int[] parent;
    int[] size;

    public int removeStones(int[][] stones) {
        parent = new int[stones.length];
        size = new int[stones.length];

        for(int i=0;i<stones.length;i++){
            parent[i] = i;
            size[i] = 1;
        }

        HashMap<Integer,Integer> rmap = new HashMap<>();
        HashMap<Integer,Integer> cmap = new HashMap<>();

        for(int i=0;i<stones.length;i++){
            int x = stones[i][0], y = stones[i][1];

            if(!rmap.containsKey(x)){
                rmap.put(x, i);
            }
            else{
                union(rmap.get(x), i);
                rmap.put(x, i);
            }

            if(!cmap.containsKey(y)){
                cmap.put(y, i);
            }
            else{
                union(cmap.get(y), i);
                cmap.put(y, i);
            }
        }

        // count no.of components
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<stones.length;i++){
            set.add(findParent(i));
        }

        int components = set.size();

        return stones.length-components;
    }
    public int findParent(int x){
        if(x != parent[x]){
            parent[x] = findParent(parent[x]);
        }

        return parent[x];
    }
    public void union(int x, int y){
        int px = findParent(x);
        int py = findParent(y);

        if(px == py){
            return;
        }

        if(size[px] < size[py]){
            size[py] += size[px];
            parent[px] = py;
        }
        else{
            size[px] += size[py];
            parent[py] = px;
        }
    }
}