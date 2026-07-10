// lcm = (a*b) / gcd

class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];

        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return find_GCD(min, max);
    }
    public int find_GCD(int a, int b){
        if(b == 0)return a;

        return find_GCD(b, a%b);
    }
}