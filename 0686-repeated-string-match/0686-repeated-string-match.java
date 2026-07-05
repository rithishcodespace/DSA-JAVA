// brute force

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt = 1;
        String c = new String(a);
        while(!c.contains(b) && c.length()<b.length()){
            c += a;
            cnt++;
        }

        if(c.contains(b)){
            return cnt;
        }

        c += a;

        if(c.contains(b)){
            return cnt+1;
        }

        return -1;
    }
}