// If stale max_freq lets the window become larger than what is actually valid, won't ans become larger than the correct answer? 
//
// It won't create a false maxLen because after the current window becomes invalid,
// simply shrinking max_freq earlier cannot produce a larger valid window. A larger answer
// is only possible after max_freq increases while expanding.

// otherwise, if you expect to recalculate maxfreq on each shrink, it cause extra tc of O(n)*26

// tc: O(n)
// sc: O(26)

class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, r=0, max_freq=0, maxLen=0;
        int[] hmap = new int[26];

        while(r<s.length()){
            // expand
            hmap[s.charAt(r)-'A']++;
            if(hmap[s.charAt(r)-'A'] > max_freq)max_freq = hmap[s.charAt(r)-'A'];

            // validate
            while((r-l+1)-max_freq > k){
                hmap[s.charAt(l)-'A']--;
                l++;
            }

            // update ans
            maxLen = Math.max(r-l+1, maxLen);

            r++;
        }

        return maxLen;
    }
}