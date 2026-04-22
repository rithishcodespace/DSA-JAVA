// group all equal element
// for ! condition, check whether a and b have same parent(false) else (true)

class Solution {

    int[] parent;
    int[] size;

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        size = new int[26];

        for(int i=0;i<26;i++){
            parent[i] = i;
            size[i] = 1;
        }    

        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1) == '='){
                int u = equations[i].charAt(0)-97;
                int v = equations[i].charAt(3)-97;

                union(u,v);
            }    
        }

        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                int u = eq.charAt(0)-97;
                int v = eq.charAt(3)-97;

                if(findParent(u) == findParent(v)){
                    return false;
                }
            }
        }

        return true;
    }

    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv)return;

        int u_size = size[pu];
        int v_size = size[pv];

        if(u_size > v_size){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }

    public int findParent(int node){
        if(node != parent[node]){
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }
}