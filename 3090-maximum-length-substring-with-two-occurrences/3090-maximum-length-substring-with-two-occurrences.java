class Solution {
    public int maximumLengthSubstring(String s) {
        int l=0, r=0, max=0;
        int[] freq = new int[26];

        while(r < s.length()){
            int key = s.charAt(r)-97;

            freq[key]++;

            while(freq[key] > 2){
                freq[(s.charAt(l++)-97)]--;
            }

            max = Math.max(max, (r-l)+1);
            r++;
        }

        return max;
    }
}