// pick and non-pick
// pick idx not moves, but non-pick idx moves forward

// no dp, since there is overlapping 

// tc: O(2^n)
// sc: O(n) (excluding output array)

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(0, candidates, target, new ArrayList<>());
        return ans;
    }

    public void solve(int idx, int[] candidates, int target, List<Integer> list){
        if(idx == candidates.length || target <= 0){
            if(target == 0)ans.add(new ArrayList<>(list));
            return;
        }

        // pick
        list.add(candidates[idx]);
        solve(idx, candidates, target-candidates[idx], list);
        // backtrack
        list.remove(list.size()-1);

        // not-pick
        solve(idx+1, candidates, target, list);
    }
}