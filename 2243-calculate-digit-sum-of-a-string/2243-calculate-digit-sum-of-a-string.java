class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){

            StringBuilder sb = new StringBuilder();

            int currSum = 0;
            int len = 0;

            for(int i=0;i<s.length();i++) {

                currSum += s.charAt(i) - '0';
                len++;

                if(len == k || i == s.length() - 1){
                    sb.append(currSum);
                    currSum = 0;
                    len = 0;
                }
            }

            s = sb.toString();
        }

        return s;
    }
}