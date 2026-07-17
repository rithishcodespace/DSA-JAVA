class Solution {
    public int longestPalindrome(String s) {
        int len = 0, odd = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }  

        for(char key : map.keySet()){
            if(map.get(key)%2 == 0)len += map.get(key);
            else{
                len += map.get(key)-1;
                odd=1;
            }
        }     

        return len+odd;
    }
}