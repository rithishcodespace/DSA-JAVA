// generating ungly numbers:
// start from 1
// 1*2=2, 1*3=3, 1*5=2
// 2*2=4, 2*3=6, 2*5=10
// 3*2=6, 3*3=9, 3*5=15
// ....

// here, We are building ugly numbers in sorted order instead of generating random numbers and sorting them. 
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for(int i=1;i<n;i++){
            int next2 = dp[i2]*2;
            int next3 = dp[i3]*3;
            int next5 = dp[i5]*5;

            dp[i] = Math.min(next2, Math.min(next3, next5));

            if(dp[i] == next2)i2++;
            if(dp[i] == next3)i3++;
            if(dp[i] == next5)i5++;
        }

        return dp[n-1];
    }
}