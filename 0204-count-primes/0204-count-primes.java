// multiples of primes are always composite
// after root(n), we will get same relations (already seen)

class Solution {
    public int countPrimes(int n) {
        if(n <= 1)return 0;

        boolean[] primes = new boolean[n];
        
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        // mark the composite numbers
        for(int i=2;i<Math.sqrt(n);i++){
            if(primes[i]){
                for(int j=i*i;j<n;j+=i){
                    primes[j] = false;
                }
            }
        }

        // count the prime numbers
        int count=0;
        for(int i=0;i<n;i++){
            if(primes[i]){
                count++;
            }
        }

        return count;
    }
}