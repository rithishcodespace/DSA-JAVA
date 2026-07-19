// choosen -> second behavior

// n=15
// Step 0 : s
// Step 1 : s + m
// Step 2 : s + m - 1
// Step 3 : s + 2m - 1
// Step 4 : s + 2m - 2
// Step 5 : s + 3m - 2
// Step 6 : s + 3m - 3
// Step 7 : s + 4m - 3
// Step 8 : s + 4m - 4
// Step 9 : s + 5m - 4
// Step 10: s + 5m - 5
// Step 11: s + 6m - 5
// Step 12: s + 6m - 6
// Step 13: s + 7m - 6 (this part is the answer for both even and odd n)
// Step 14: s + 7m - 7

class Solution {
    public long maximumValue(long n, long s, int m) {      
        return (n == 1) ? s : (s+((n/2)*m)) - ((n/2)-1);
    }
}