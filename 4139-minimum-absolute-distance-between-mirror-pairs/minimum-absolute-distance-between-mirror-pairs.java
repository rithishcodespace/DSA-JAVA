class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                min = Math.min(min, i - map.get(nums[i]));
            }

            int rev = reverse(nums[i]);
            map.put(rev, i);
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    public int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }
}