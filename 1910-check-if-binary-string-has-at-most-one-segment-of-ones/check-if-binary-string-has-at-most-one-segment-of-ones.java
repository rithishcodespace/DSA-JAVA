class Solution {
    public boolean checkOnesSegment(String s) {
        int one = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                if(one == -1)one = i;
                else if(one+1 != i)return false;
                else one = i;
            }
        }
        return true;
    }
}