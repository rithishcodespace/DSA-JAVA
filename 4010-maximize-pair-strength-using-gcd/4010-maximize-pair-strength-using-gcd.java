class Solution {
    public long maxPairStrength(int[] nums) {
        long max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                long res = gcd(nums[i], nums[j]);
                long strength = (((long)nums[i]*nums[j]) / (res*res));
                max = Math.max(strength, max);
            }
        }

        return max;
    }
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}