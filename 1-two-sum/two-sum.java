// O(n) -> hashmap
class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] arr = new int[2];
      HashMap<Integer,Integer> hmap = new HashMap<>();
      for(int i=0;i<nums.length;i++)
      {
        int needed = target - nums[i];
        if(hmap.containsKey(needed)){
            arr[0] = hmap.get(needed);
            arr[1] = i;
            return arr;
        }
        hmap.put(nums[i],i);
      }   
      return arr;
    }
}