// same transition used in subset I to subset II

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(0, target, candidates, new ArrayList<>());
        return ans;
    }

    public void solve(int idx, int target, int[] candidates, List<Integer> list){
        if(idx == candidates.length || target <= 0){
            if(target == 0)ans.add(new ArrayList<>(list));
            return;
        }

        // pick
        list.add(candidates[idx]);
        solve(idx+1, target-candidates[idx], candidates, list);
        list.remove(list.size()-1); // backtrack

        // skip duplicates
        while(idx+1 < candidates.length && candidates[idx] == candidates[idx+1]){
            idx++;
        }

        // not pick
        solve(idx+1, target, candidates, list);
    }
}