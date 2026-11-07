class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.add(num);
        }

        while(!pq.isEmpty() && k-- > 0){
            pq.add(pq.poll()+1);
        }

        long num = 1;
        while(!pq.isEmpty()){
            num = (num * pq.poll()) % 1000000007;
        }

        return (int)num;
    }
}