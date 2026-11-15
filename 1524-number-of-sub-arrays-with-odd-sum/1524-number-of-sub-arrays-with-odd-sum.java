// same as subarray sums divisible by k
// note: zero should start at 1, because before processing any elements, the sum is 0 (even).
// Without that, you’ll miss subarrays starting from index 0 when the sum is odd.

class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans = 0, sum = 0, one = 0, zero = 1;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum%2 == 0){ // even - odd = odd
                ans += one;
                zero++;
            }
            else{ // odd - even = odd
                ans += zero;
                one++;
            }
        }
        return (int)(ans%1000000007);
    }
}