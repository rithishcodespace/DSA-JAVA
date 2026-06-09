class Solution {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;

        long ans = (power(5,even) * power(4,odd)) % MOD;

        return (int)ans;
    }
    public long power(long base, long exp){
        long res = 1;

        while(exp > 0){
            if((exp & 1) == 1){
                res = (res * base)%MOD;
            }
            
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}