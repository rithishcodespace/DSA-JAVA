class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<text.length();i++){
            hmap.put(text.charAt(i),hmap.getOrDefault(text.charAt(i),0)+1);
        }
        String s = "balloon";
        int min = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            int freq = hmap.getOrDefault(s.charAt(i),0);
            if(s.charAt(i) == 'l' || s.charAt(i) == 'o'){
                freq /= 2;
            }
            min = Math.min(min,freq);
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}