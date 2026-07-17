// pick and non-pick
// not dp, since there is not overlapping problems

// tc: O(n * 2^n)
// sc: O(n) (excluding output)
// sc: O(n * 2^n) (including output)

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        solve(0, nums, new ArrayList<>());
        return ans;
    }

    public void solve(int idx, int[] nums, List<Integer> list){
        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        // pick
        list.add(nums[idx]);
        solve(idx+1, nums, list);
        // backtrack
        list.remove(list.size()-1);

        // not-pick
        solve(idx+1, nums, list);
    }
}