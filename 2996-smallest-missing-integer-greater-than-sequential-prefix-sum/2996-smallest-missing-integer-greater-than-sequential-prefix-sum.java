class Solution {
    public int missingInteger(int[] nums) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, 1);
        }

        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i] != nums[i - 1] + 1){
                break;
            }
            sum += nums[i];
        }

        while(map.containsKey(sum)){
            sum++;
        }

        // System.out.println(sum);
        return sum;
    }
}