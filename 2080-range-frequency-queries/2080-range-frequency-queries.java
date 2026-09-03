// each node in segment tree will maintian a freq_map

class RangeFreqQuery {

    int n;
    HashMap<Integer,Integer>[] tree;

    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        tree = (HashMap<Integer, Integer>[])new HashMap[n*4];

        build(0, 0, n-1, arr);
    }
    
    public int query(int left, int right, int value) {
        return query(0, 0, n-1, left, right, value);
    }

    public int query(int node, int start, int end, int l, int r, int value){
        // no overlap
        if(r < start || end < l){
            return 0;
        }
        // full overlap
        if(l <= start && end <= r){
            return tree[node].getOrDefault(value,0);
        }
        // partial overlap
        int mid = (start+end)/2;
        int leftFreq = query(2*node+1, start, mid, l, r, value);
        int rightFreq = query(2*node+2, mid+1, end, l, r, value);

        return leftFreq+rightFreq;
    }

    public void build(int node, int start, int end, int[] arr){
        if(start >= end){
            tree[node] = new HashMap<>();
            tree[node].put(arr[start],1);
            return; 
        }

        int mid = (start+end)/2;

        build(2*node+1, start, mid, arr);
        build(2*node+2, mid+1, end, arr);

        // merge both hashmaps
        tree[node] = new HashMap<>();

        for(int key : tree[2*node+1].keySet()){
            tree[node].put(key, tree[node].getOrDefault(key,0)+tree[2*node+1].get(key));
        }
        for(int key : tree[2*node+2].keySet()){
            tree[node].put(key, tree[node].getOrDefault(key,0)+tree[2*node+2].get(key));
        }
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */