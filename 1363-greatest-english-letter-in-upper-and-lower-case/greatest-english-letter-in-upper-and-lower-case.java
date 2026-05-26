class Solution {
    public String greatestLetter(String s) {
        int[] sm = new int[26];
        int[] bg = new int[26];

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                sm[ch-'a'] = 1;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                bg[ch-'A'] = 1;
            }
        } 

        for(int i=25;i>=0;i--){
           if(sm[i] == 1 && bg[i] == 1)
            return String.valueOf((char)(i + 'A'));
           }

        return "";
    }
}