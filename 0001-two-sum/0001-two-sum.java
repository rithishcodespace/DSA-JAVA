// time: O(n)
// space: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int need = target-nums[i];
            if(hmap.containsKey(need)){
                return new int[]{hmap.get(need), i};
            }       
            hmap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}