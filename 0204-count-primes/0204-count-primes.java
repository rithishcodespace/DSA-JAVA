// sieve of erathroses

class Solution {
    public int countPrimes(int n) {
        if(n <= 1)return 0;
        boolean[] arr = new boolean[n];

        for(int i=2;i*i <= n;i++){
            if(isPrime(i)){
                // mark multiplies of i
                for(int j=2;j*i < n;j++){
                    arr[j*i] = true;
                }                                               
            }
        }

        // count non false cells
        int cnt = 0;
        for(int i=2;i<arr.length;i++){
            if(!arr[i])cnt++;
        }

        return cnt;
    }
    public boolean isPrime(int n){
        if(n == 2)return true;

        for(int i=2;i<n;i++){
            if(n%i == 0)return false;
        }

        return true;
    }
}