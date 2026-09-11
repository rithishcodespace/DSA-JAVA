class Solution {
    HashMap<Integer,Integer> hmap = new HashMap<>();
    public int totalNumbers(int[] digits) {
        int ans = 0;
        // List<Integer> list = new ArrayList<>();
        for(int i=0;i<digits.length;i++){
            hmap.put(digits[i],hmap.getOrDefault(digits[i],0)+1);
        }
        for(int i=100;i<=999;i++){
            if(test(i)){
                // list.add(i);
                ans++;
            }
        }
        // return list.size();
        return ans;
    }
    public boolean test(int num){
        if(num%2 != 0)return false;
        HashMap<Integer,Integer> temp = new HashMap<>(hmap);   
        while(num > 0){
            if(!temp.containsKey(num%10))return false;
            temp.put(num%10,temp.get(num%10)-1);
            if(temp.get(num%10) == 0)temp.remove(num%10);
            num /= 10;
        }
        return true;
    }
}