// keep only k highest elements in the heap (minHeap)
// so the peak would the k'th largest one

class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}