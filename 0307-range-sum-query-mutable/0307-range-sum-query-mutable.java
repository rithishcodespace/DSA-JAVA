// check range(l,r) inside nodes (start,end)

class NumArray {

    int n;
    int[] tree;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n*4];

        build(0, 0, n-1, nums);
    }
    
    public void update(int index, int val) {
        update(0, 0, n-1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sumRange(0, 0, n-1, left, right);
    }

    public void update(int node, int start, int end, int idx, int val){
        // base case
        if(start == end){
            tree[node] = val;
            return;
        }
        // to find the index, whether the index exists in the current nodes range
        int mid = (start+end)/2;

        if(idx <= mid){
            update(2*node+1, start, mid, idx, val);
        }
        else{
            update(2*node+2, mid+1, end, idx, val);
        }

        tree[node] = tree[2*node+1] + tree[2*node+2];
    }

    public int sumRange(int node, int start, int end, int l, int r){
        // no-overlap
        if(r < start || end < l){
            return 0;
        }
        // complete overlap
        if(l <= start && end <= r){
            return tree[node];
        }
        // partial overlap -> further divide it to find complete overlap
        int mid = (start+end)/2;

        int leftSum = sumRange(2*node+1, start, mid, l, r);
        int rightSum = sumRange(2*node+2, mid+1, end, l, r);

        return leftSum + rightSum;
    }

    public void build(int node, int start, int end, int[] arr){
        // base case - leaf node
        if(start == end){ 
            tree[node] = arr[start];
            return;
        }

        // divide the range into left and right

        int mid = (start+end)/2;

        build(2*node+1, start, mid, arr);
        build(2*node+2, mid+1, end, arr);

        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */