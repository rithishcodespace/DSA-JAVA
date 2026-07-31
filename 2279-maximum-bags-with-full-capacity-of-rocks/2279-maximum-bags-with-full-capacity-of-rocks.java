class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);

        for(int i=0;i<capacity.length;i++){
            minHeap.add(capacity[i]-rocks[i]);
        }

        int filled = 0;

        while(!minHeap.isEmpty()){
            int need = minHeap.poll();

            if(need <= additionalRocks){
                additionalRocks -= need;
                filled++;
            }
            else break;
            
        }

        while(!minHeap.isEmpty()){
            int need = minHeap.poll();
            filled += (need == 0) ? 1 : 0;
        }

        return filled;
    }
}
class Element{
    int capacity, rocks, idx;

    Element(int capacity, int rocks, int idx){
        this.capacity = capacity;
        this.rocks = rocks;
        this.idx = idx;
    }
}