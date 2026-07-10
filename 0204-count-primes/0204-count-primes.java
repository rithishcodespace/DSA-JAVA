// when the factors exceeds root(n), we will again get the same relation, it is better to stop here

// eg: 36
// 36 = 1 × 36
// 36 = 2 × 18
// 36 = 3 × 12
// 36 = 4 × 9
// 36 = 6 × 6
// 36 = 9 × 4
// 36 = 12 × 3
// 36 = 18 × 2
// 36 = 36 × 1

class Solution {
    public int countPrimes(int n) {
        if(n <= 1)return 0;

        int[] primes = new int[n];
        Arrays.fill(primes,1);
        primes[0] = 0;
        primes[1] = 0;

        for(int i=2;i<Math.sqrt(n);i++){
            if(primes[i] != 0){ // multiples of primes are always composite
                for(int j=i*i;j<n;j+=i){
                    primes[j] = 0;
                }
            }
        }

        int count = 0;
        for(int i=0;i<primes.length;i++){
            count += primes[i];
        }

        return count;
    }
}