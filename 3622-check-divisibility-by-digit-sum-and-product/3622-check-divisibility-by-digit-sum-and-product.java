class Solution {
    public boolean checkDivisibility(int n) {
        int dsum = 0, dpro = 1, given = n;

        while(n > 0){
            int x = n%10;
            dsum += x;
            dpro *= x;
            n /= 10;
        }

        return given%(dsum+dpro) == 0;
    }
}