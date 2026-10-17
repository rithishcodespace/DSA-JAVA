// ans = n - no.of cycles

// no.of swaps to sort the cycle = no.of elements in cycle - 1
// sum of these values is also gives answer

// deteching cycles seperates indexes into groups, so we can avoid unnecessary swaps

class Solution {
    public int minSwaps(int[] nums) {
        // create correct mapping
        int[] p = new int[nums.length];
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) -> {
            if(a.sum != b.sum){
                return a.sum-b.sum;
            }
            return a.value-b.value;
        });

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int sum = findSum(num);

            minHeap.add(new Element(num, sum, i));
        }

        int idx = 0;
        while(!minHeap.isEmpty()){
            Element e = minHeap.poll();

            p[e.idx] = idx++;
        }

        // find no.of cycles - start from each index
        int cycles = 0;
        boolean[] visited = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                cycles++;
                int j=i;
                while(!visited[j]){
                    visited[j] = true;
                    j = p[j];
                }
            }
        }

        return nums.length-cycles;
    }
    public int findSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }

        return sum;
    }
}

class Element{
    int value, sum, idx;

    Element(int value, int sum, int idx){
        this.value = value;
        this.sum = sum;
        this.idx = idx;
    }
}