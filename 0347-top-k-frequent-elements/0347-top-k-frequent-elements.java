// max-heap => time = O(nlogn, space = O(n)
// min-heap => time = O(nlogk), space = O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // frequency map
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        // min-heap (eliminate when size exceeds k)
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) -> a.freq-b.freq);

        for(int key : map.keySet()){
            minHeap.add(new Element(key, map.get(key)));
            if(minHeap.size() > k)minHeap.poll();
        }

        // collect first k elements
        int idx = 0;
        int[] ans = new int[k];
        while(!minHeap.isEmpty()){
            ans[idx++] = minHeap.poll().key;
        }

        return ans;
    }
}
class Element{
    int key, freq;

    Element(int key, int freq){
        this.key = key;
        this.freq = freq;
    }
}