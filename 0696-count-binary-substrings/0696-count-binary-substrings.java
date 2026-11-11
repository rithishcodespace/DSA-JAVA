// Eg: "00011100" --> [3 zeroes, 3 ones, 2 zeroes] --> [3,3,2] --> Ans = min(3,3) + min(3,2) = 5 Total Substrings
class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0, curr = 1, cnt = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                curr++;
            }
            else{
                cnt += Math.min(curr,prev);
                prev = curr;
                curr = 1;
            }
        }
        cnt += Math.min(curr,prev);
        return cnt;
    }
}
