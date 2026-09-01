class NumArray {

    int n;
    int[] tree;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n*4];

        build(0, 0, n-1, nums);
    }
    
    public int sumRange(int left, int right) {
        return sumRange(0, 0, n-1, left, right);
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