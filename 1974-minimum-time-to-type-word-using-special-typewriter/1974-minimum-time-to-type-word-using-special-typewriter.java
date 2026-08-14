class Solution {
    public int minTimeToType(String word) {
        int sec = 0;
        char prev = 'a';

        for(char ch : word.toCharArray()){
            int distance = Math.abs(prev-ch);
            int clock = distance;
            int anticlock = 26 - distance;

            sec += Math.min(clock, anticlock); // move to ch

            sec++; // type the ch

            prev = ch;
        }

        return sec;
    }
}