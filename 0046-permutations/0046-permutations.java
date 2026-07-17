// for each index (fill with available elements)

// Time: O(n * n!)
// Space: O(n)             // auxiliary (recursion + list + map)
// Output Space: O(n * n!)

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        solve(0, nums, new ArrayList<>(), map);
        return ans;
    }

    public void solve(int idx, int[] nums, List<Integer> list, HashMap<Integer,Integer> map){
        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        // place every possible val in this index
        for(int key : map.keySet()){
            if(map.get(key) > 0){
                list.add(key);
                map.put(key, map.get(key)-1);

                solve(idx+1, nums, list, map); 

                list.remove(list.size()-1); // backtrack
                map.put(key, map.getOrDefault(key,0)+1);
            }
        }
    }
}