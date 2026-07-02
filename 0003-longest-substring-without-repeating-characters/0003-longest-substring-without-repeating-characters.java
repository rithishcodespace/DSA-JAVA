// tc: O(n)
// sc: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, maxLen=0;
        HashMap<Character,Integer> hmap = new HashMap<>();

        while(r<s.length()){
            // expand
            hmap.put(s.charAt(r), hmap.getOrDefault(s.charAt(r),0)+1);

            // validate
            while(hmap.get(s.charAt(r)) > 1){
                hmap.put(s.charAt(l),hmap.get(s.charAt(l))-1);
                l++;
            }

            // save ans
            maxLen = Math.max(maxLen,r-l+1);

            r++;
        }

        return maxLen;
    }
}