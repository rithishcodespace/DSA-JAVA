class Solution {

    int step = -1;
    int[] parent;
    int[] size;

    public int findLatestStep(int[] arr, int m) {
        int[] bits = new int[arr.length+1];
        int[] count = new int[arr.length+1];

        parent = new int[arr.length+1];
        size = new int[arr.length+1];

        for(int i=1;i<=arr.length;i++){
            parent[i] = i;
            size[i] = 1;
        } 

        for(int i=0;i<arr.length;i++){
            bits[arr[i]] = 1;
            int leftSize = 0, rightSize = 0;

            if(arr[i]-1 >= 1 && bits[arr[i]-1] == 1){
                int leftParent = findParent(arr[i]-1);
                leftSize = size[leftParent];

                union(arr[i]-1, arr[i]);
            }
            if(arr[i]+1 < bits.length && bits[arr[i]+1] == 1){
                int rightParent = findParent(arr[i]+1);
                rightSize = size[rightParent];

                union(arr[i]+1, arr[i]);
            }

            if(leftSize > 0)count[leftSize]--;
            if(rightSize > 0)count[rightSize]--;

            int p = findParent(arr[i]);
            int ps = size[p];
            count[ps]++;

            if(count[m] > 0){
                step = i+1;
            }
        }

        return step;
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