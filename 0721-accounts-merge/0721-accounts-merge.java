class Solution {
    int[] parent;
    int[] size;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[accounts.size()+1];
        size = new int[accounts.size()+1];

        for(int i=0;i<=accounts.size();i++){
            parent[i] = i;
            size[i] = 1;
        }

        // merge emails of same person
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);

                if(!map.containsKey(email)){
                    map.put(email, i);
                }
                else{
                    union(i, map.get(email));
                }
            }
        }

        // group emails by parent
        HashMap<Integer,List<String>> pmap = new HashMap<>();

        for(String email : map.keySet()){
            int p = findParent(map.get(email));

            if(!pmap.containsKey(p)){
                pmap.put(p, new ArrayList<>());
            }
            pmap.get(p).add(email);
        }

        // build the answer
        List<List<String>> res = new ArrayList<>();

        for(int idx : pmap.keySet()){
            String name = accounts.get(idx).get(0);
            List<String> emails = pmap.get(idx);
            Collections.sort(emails);

            List<String> temp = new ArrayList<>();

            temp.add(name);
            temp.addAll(emails);

            res.add(temp);
        }

        return res;
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