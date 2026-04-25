class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = Integer.MIN_VALUE;
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hmap.containsKey(s.charAt(i))){
                max = Math.max(max,(i-hmap.get(s.charAt(i)))-1);
            }
            else hmap.put(s.charAt(i),i);
        }

        return (max < 0) ? -1 : max;
    }
}