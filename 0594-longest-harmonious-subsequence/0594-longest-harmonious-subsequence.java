class Solution {
    public int findLHS(int[] nums) {
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            // if 3, check for 2
            int balance = nums[i]-1;

            if(map.containsKey(balance)){
               int count = map.get(balance) + map.getOrDefault(nums[i],0)+1;
               maxLen = Math.max(maxLen, count);
            }

            // if 3, check for 4
            balance = nums[i]+1;
            if(map.containsKey(balance)){
               int count = map.get(balance) + map.getOrDefault(nums[i],0)+1;
               maxLen = Math.max(maxLen, count);
            }
            
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        return maxLen;
    }
}