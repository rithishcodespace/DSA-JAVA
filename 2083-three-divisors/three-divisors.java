// A number has exactly 3 divisors only when it is the square of a prime number.
// 4  = 2²  -> divisors: 1, 2, 4
class Solution {
    public boolean isThree(int n) {
        int root = (int)Math.sqrt(n);
        return (isPrime(root) && root*root == n) ? true : false;
    }
    public boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2)return true;

        for(int i=2;i<n;i++){
            if(n%i == 0)return false;
        }

        return true;
    }
}