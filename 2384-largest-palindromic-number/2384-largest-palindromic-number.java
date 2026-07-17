class Solution {
    public String largestPalindromic(String num) {
        char odd = 'a';
        StringBuilder leftHalf = new StringBuilder();
        StringBuilder rightHalf = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<num.length();i++){
            map.put(num.charAt(i), map.getOrDefault(num.charAt(i),0)+1);
        }

        for(int i=9;i>=0;i--){
            if(i == 0 && leftHalf.length() == 0)continue;
            if(map.containsKey((char)(i+'0')) && map.get((char)(i+'0'))%2 == 0){
                leftHalf.append(gen((char)(i+'0'), map.get((char)(i+'0'))/2));
                rightHalf.append(gen((char)(i+'0'), map.get((char)(i+'0'))/2));
            }
            else if(map.containsKey((char)(i+'0'))){
                rightHalf.append(gen((char)(i + '0'), (map.get((char)(i + '0')) - 1) / 2));
                leftHalf.append(gen((char)(i + '0'), (map.get((char)(i + '0')) - 1) / 2));
                if(odd == 'a')odd = (char)(i+'0');
            }
        }

        if(map.size() == 1 && map.containsKey((char)(0+'0')))return "0";

        if(odd == 'a')return leftHalf.toString() + rightHalf.reverse().toString();

        return leftHalf.toString() + odd + rightHalf.reverse().toString();
    }
    public String gen(char ch, int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(ch);
        }
        return sb.toString();
    }
}