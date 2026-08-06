class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<1000;i++){
            if(pro(i)%t == 0)return i;
        }
        return -1;
    }
    public int pro(int n){
        int val = 1;
        while(n > 0){
            val = val*(n%10);
            n /= 10;
        }
        return val;
    }
}