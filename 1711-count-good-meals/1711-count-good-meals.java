// similar to two sum's hashtable implementation
// generate all possible 2powers (21 since constraints)

// tc: O(n*21)
// sc: O(n)

class Solution {
    public int countPairs(int[] deliciousness) {
        long count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<deliciousness.length;i++){
            // check if 2^(0 to 21) - deliciousness[i] is already seen
            for(int j=0;j<=21;j++){
                int power = 1 << j;
                int rem = power-deliciousness[i];
                if(map.containsKey(rem)){
                    count += map.get(rem); // rem: freq (to count no.of pairs can be made including it)
                }
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i],0)+1);
        }

        return (int)(count%1000000007);
    }
}