class Solution {
    public String smallestPalindrome(String s) {
        char ch = '#';
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        TreeMap<Character,Integer> map = new TreeMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        for(char key : map.keySet()){
            int cnt = map.get(key);
            if(cnt % 2 == 1){
                cnt--;
                if(ch == '#')ch = key;
            }
            build(left, cnt/2, key);
            build(right, cnt/2, key);
        }

        String mid = (ch != '#') ? String.valueOf(ch) : "";

        return left.toString() + mid + right.reverse().toString();
    }
    public void build(StringBuilder sb, int n, char ch){
        while(n-- > 0){
            sb.append(ch);
        }
    }
}