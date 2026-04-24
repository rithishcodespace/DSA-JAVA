class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        // find which dir is dominant
        int l=0, r=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i) == 'L')l++;
            else if(moves.charAt(i) == 'R')r++;
        }
        char ch = (l >= r) ? 'L' : 'R';

        // replace _ with choosed
        int point = 0;
        for(char c : moves.toCharArray()){
            if(c == '_')c = ch;
            if(c == 'L')point--;
            else point++;
        }

        return Math.abs(0-point);
    }
}