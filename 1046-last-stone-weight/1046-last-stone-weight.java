class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();

            pq.add(y-x);
        }

        return pq.poll();
    }
}