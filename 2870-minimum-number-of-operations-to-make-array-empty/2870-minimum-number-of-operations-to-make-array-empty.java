class Solution {
    public int minOperations(int[] tasks) {
        int rounds = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int task : tasks){
            map.put(task, map.getOrDefault(task,0)+1);
        }

        for(int key : map.keySet()){
            while(map.get(key) >= 2){
                rounds++;
                if(map.get(key)%3 == 0)map.put(key, map.get(key)-3);
                else if(map.get(key)%2 == 0)map.put(key, map.get(key)-2);
                else{
                    map.put(key, map.get(key)-2);
                }
            }
            if(map.get(key) != 0){
                return -1;
            }
        }

        return rounds;
    }
}