class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        if(x==-1){
            return n%2==0?1:-1;
        }
        if (n == 1) {
            return x;
        }
        double result = 1;
        for (int i = 0; i < Math.abs((long)n); i++) {
            result = result * x;
            if(result>100000)
            break;
        }
        System.out.print(result);
        return (n > 0) ? result : (1 / result);
    }
}