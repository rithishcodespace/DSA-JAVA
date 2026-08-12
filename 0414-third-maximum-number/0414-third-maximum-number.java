// O(n)

class Solution {
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums)set.add(num);

        for(int num : set){
            max = Math.max(max, num);

            minHeap.add(num);

            while(minHeap.size() > 3){
                minHeap.poll();
            }
        }

        return (minHeap.size() == 3) ? minHeap.peek() : max;
    }
}