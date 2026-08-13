class Solution {
    public boolean isPossibleDivide(int[] hands, int groupSize) {
        if (hands.length % groupSize != 0)return false;

        int groups = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i=0;i<hands.length;i++){
            map.put(hands[i], map.getOrDefault(hands[i],0)+1);
        }

        while(!map.isEmpty()){
            int first = map.firstKey();
            for(int i=0;i<groupSize;i++){
                int key = first+i;

                if(map.containsKey(key)){
                    map.put(key, map.get(key)-1);
                    if(map.get(key) == 0)map.remove(key);
                }
                else return false;
            }
        }

        return true;
    }
}