class Solution {
    public int countPrimes(int n) {
        if(n <= 1)return 0;

        boolean[] primes = new boolean[n]; 
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for(int i=2;i<Math.sqrt(n);i++){
            if(primes[i] == true){
                for(int j=i*i;j<n;j+=i){
                    primes[j] = false;
                }
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            count += primes[i] ? 1 : 0;
        }

        return count;
    }
}