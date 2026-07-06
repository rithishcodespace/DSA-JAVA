class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for(int i=2;i<=n;i++){
            sb = generateString(sb);
        }
        return sb.toString();
    }
    public StringBuilder generateString(StringBuilder sb){
        sb.append("9");
        int count = 1;
        StringBuilder str = new StringBuilder();
        for(int i=1;i<sb.length();i++){
            char prev = sb.charAt(i-1);
            char curr = sb.charAt(i);

            if(prev == curr){
                count++;
            }
            else{
                str.append((char)(count+'0'));
                str.append(prev);

                count = 1;
            }
        }

        return str;
    }
}