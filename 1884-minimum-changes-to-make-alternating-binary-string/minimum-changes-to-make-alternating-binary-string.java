class Solution {
    public int minOperations(String s) {
        // created expected patterns -> pattern 1 - start with 1 -> pattern 2 - start with 0
        StringBuilder pattern1 = new StringBuilder();
        StringBuilder pattern2 = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i%2 == 0){
                pattern1.append('1');
                pattern2.append('0');
            }
            else{
                pattern1.append('0');
                pattern2.append('1');
            } 
        }
        // check if the given string matches the expected patterns
        int p1 = 0, p2 = 0;
        for(int i=0;i<s.length();i++){
            if(pattern1.charAt(i) != s.charAt(i))p1++;
            if(pattern2.charAt(i) != s.charAt(i))p2++;
        }
        return Math.min(p1,p2);
    }
}