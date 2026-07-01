// tc: O(n)
// sc: O(1)

class Solution {
    public boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;
        while(l < r){
            char ch1='a', ch2='a';
            while(l < s.length() && !isAlphaNum(s.charAt(l))){
                l++;
            }
            while(r >= 0 && !isAlphaNum(s.charAt(r))){
                r--;
            }
            if(l < s.length())ch1 = Character.toLowerCase(s.charAt(l));
            if(r >= 0)ch2 = Character.toLowerCase(s.charAt(r));

            if(ch1 != ch2)return false;

            l++;r--;
        }

        return true;
    }
    public boolean isAlphaNum(char ch){
        return (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9') ? true : false;
    }
} 