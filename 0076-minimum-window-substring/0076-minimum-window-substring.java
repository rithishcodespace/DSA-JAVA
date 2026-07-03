// instead of checking each character of t is covered, we each each character of t is either consumed ?

// tc: O(n)
// sc: O(n)

class Solution {
    public String minWindow(String s, String t) {
        int l=0, r=0, startIdx=0, minLen=Integer.MAX_VALUE, consumedCount=0;
        HashSet<Character> set = new HashSet<>(); // to check either the current character, present in t or not
        HashMap<Character,Integer> map = new HashMap<>(); // to consume the frequency later

        // mark t
        for(int i=0;i<t.length();i++){
            set.add(t.charAt(i));
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        int validLength = set.size();

        // sliding window
        while(r<s.length()){
           // expand
           map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)-1); // consume
           if(map.get(s.charAt(r)) == 0)consumedCount++;

           // validate - to get a smaller window length
           while(consumedCount == validLength){
                // save ans
                if((r-l+1) < minLen){
                    minLen = r-l+1;
                    startIdx = l;
                }
                map.put(s.charAt(l), map.get(s.charAt(l))+1);
                // If a part of t is removed, decrease consumed characters count
                if(set.contains(s.charAt(l)) && map.get(s.charAt(l)) == 1){
                    consumedCount--; 
                }
                l++;
           }

           r++;
        }

        if(minLen == Integer.MAX_VALUE)return "";

        return s.substring(startIdx, startIdx+minLen);
    }
}