class Solution {
    char min, max;
    public int minOperations(String s) {

        min = s.charAt(0); max = s.charAt(0);

        boolean sorted = isSorted(s);

        // if already sorted -> 0
        if(sorted)return 0;

        // invalid length to perform operations
        if(s.length() <= 2)return -1;

        // min char is at 0'th idx or max char at last index -> 1
        if(s.charAt(0) == min || s.charAt(s.length()-1) == max)return 1;

        // if min or max exist inside (1 to n-1) -> 2
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i) == min || s.charAt(i) == max)return 2;
        }

        // min and max are swapped at opposite positions
        return 3;
    }
    public boolean isSorted(String s){
        boolean res = true;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) > s.charAt(i)){
                res = false;
            }
            min = (char)Math.min(min, s.charAt(i));
            max = (char)Math.max(max, s.charAt(i));
        }

        return res;
    }
}
