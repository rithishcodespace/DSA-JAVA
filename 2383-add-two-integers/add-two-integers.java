class Solution {
    public int sum(int a, int b) {
        while(b != 0){
            int carry = (a & b) << 1;
            a = a^b; // sum
            b = carry;
        }
        return a;
    }
}