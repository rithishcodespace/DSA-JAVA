class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int prefixLen = 0, totalLen = s1.length()+s2.length()+s3.length();
        for(int i=0;i<Math.min(s1.length(), Math.min(s2.length(), s3.length()));i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            char ch3 = s3.charAt(i);

            if(ch1 != ch2 || ch2 != ch3){
                break;
            }

            prefixLen++;
        }

        return prefixLen != 0 ? (totalLen - (prefixLen*3)) : -1;
    }
}