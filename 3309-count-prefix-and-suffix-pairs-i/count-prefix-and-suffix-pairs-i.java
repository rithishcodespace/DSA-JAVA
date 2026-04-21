class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i],words[j])){
                    System.out.println(words[i]+":"+words[j]);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean isPrefixAndSuffix(String str1, String str2){
       if(str2.length() < str1.length())return false;
       // prefix
       for(int i=0;i<str1.length();i++){
        if(str1.charAt(i) != str2.charAt(i)){
            return false;
        }
       } 
       // suffix
       int idx = str2.length()-1;
       for(int i=str1.length()-1;i>=0;i--){
        if(str1.charAt(i) != str2.charAt(idx--)){
            return false;
        }
       }

       return true;
    }
}