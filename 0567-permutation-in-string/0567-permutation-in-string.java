// fixed sliding window
// tc: O(n)
// sc: O(1) // we store s1 (max 26 chars)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l=0, r=0, consumedCount=0;;
        HashSet<Character> set = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();

        // save s1 freq to consume
        for(int i=0;i<s1.length();i++){
            set.add(s1.charAt(i));
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0)+1);
        }

        while(r<s2.length()){
            if(r<s1.length()-1){ // create the fixed window 
                map.put(s2.charAt(r), map.getOrDefault(s2.charAt(r),0)-1);
                if(map.get(s2.charAt(r)) == 0){ // fully consumed a character
                    consumedCount++;
                }
            }
            else{ // maintain fixed window
                map.put(s2.charAt(r), map.getOrDefault(s2.charAt(r),0)-1);
                if(set.contains(s2.charAt(r)) && map.get(s2.charAt(r)) == 0){ // fully consumed a character
                    consumedCount++;
                }

                // validate current valid length window
                if(consumedCount == set.size()){
                    return true;
                }

                // shrink the window, to maintain window length
                // remove the consumption
                map.put(s2.charAt(l), map.get(s2.charAt(l))+1);
                if(set.contains(s2.charAt(l)) && map.get(s2.charAt(l)) == 1){
                    consumedCount--;
                }
                l++;
            }

            // expand the window
            r++;
        }

        return false;
    }
}