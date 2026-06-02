// count subsets with sum as total_sum/k

class Solution { 
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total_sum = 0;
        for(int i=0;i<nums.length;i++)total_sum += nums[i];

        if(total_sum % k != 0) return false;

        int target = total_sum/k;

        for(int num : nums){
            if(num > target) return false;
        }
        
        boolean[] used = new boolean[nums.length];
        return solve(0, 0, target, k, nums, used);
    }
    public boolean solve(int idx, int curr_sum, int target, int k, int[] nums, boolean[] used){
        
        // one subset left (so remaining elements sum must be = target)
        if(k == 1){
            return true;
        }

        // search for next subset
        if(curr_sum == target){
            return solve(0, 0, target, k-1, nums, used);
        }

        if(idx >= nums.length){
            return false;
        }

        boolean pick = false;

        // pick
        if(nums[idx] + curr_sum <= target && !used[idx]){
            used[idx] = true;
            pick = solve(idx+1, curr_sum+nums[idx], target, k, nums, used);

            // bactrack - if the subtree did not got the correct subsequence
            if(!pick){
                used[idx] = false;
            }
        }


        // not-pick
        boolean not_pick = solve(idx+1, curr_sum, target, k, nums, used);

        return (pick || not_pick);
    }
} 