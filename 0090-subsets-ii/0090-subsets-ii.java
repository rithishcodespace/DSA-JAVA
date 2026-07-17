// Backtracking (Pick / Not Pick)
// Not DP because there are no overlapping subproblems.

// Time: O(n log n + n × 2^n) = O(n × 2^n)
// Space: O(n)              // Auxiliary (includes sorting stack + recursion + current subset)
// Output Space: O(n × 2^n)

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
        
        list.remove(list.size()-1); // backtrack

        // skip all duplicates after me
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }

        // not-pick
        solve(idx+1, nums, list);
    }
}