class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l=0, r=0, ones=0;
        String word = "";

        while(r<s.length()){
            if(s.charAt(r) == '1'){
                ones++;
            }

            while(ones > k){
                if(s.charAt(l++) == '1')ones--;
            }

            if(ones == k){
                // remove leading 0's
                while(s.charAt(l) == '0')l++;

                // remove trailing 0's
                int idx = r;
                while(idx >= l && s.charAt(idx) == '0')idx--;

                String temp = s.substring(l,idx+1);

                if(word.length() == 0){
                    word = temp;
                }
                else if(word.length() == temp.length()){
                    // compare lexo
                    for(int i = 0; i < word.length(); i++){

                        if(word.charAt(i) > temp.charAt(i)){
                            word = temp;
                            break;
                        }

                        if(word.charAt(i) < temp.charAt(i)){
                            break;
                        }
                    }
                }
                else if(temp.length() < word.length()){
                    word = temp;
                }

            }
            
            r++;
        }

        return word;
    }
}