class Solution {
    public int longestPalindrome(String s) {
        int even = 0, odd = 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
        }
        for(char key : hmap.keySet()){
            if(hmap.get(key)%2 == 0){
                even += hmap.get(key);
            }
            else{
                even += hmap.get(key)-1;
                odd = 1;
            }
        }
        return even+odd;
    }
}