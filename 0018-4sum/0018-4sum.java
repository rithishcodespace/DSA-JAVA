// // fix 1'st and 2'nd element, then solve Two Sum II on the rest.

// tc: O(logn)+ O(n^3) -> O(n^3)
// sc: O(1) excluding space to store ans

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // convert two TWO SUM II
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i > 0 && nums[i] == nums[i-1])continue;
            int m=i;
            for(int j=i+1;j<nums.length-2;j++){
                if(j > i+1 && nums[j] == nums[j-1])continue;
                int n=j, o=j+1, p=nums.length-1;
                while(o<p){
                    long sum = (long)nums[m]+(long)nums[n]+(long)nums[o]+(long)nums[p];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[m], nums[n], nums[o], nums[p]));
                        o++;p--;
                        while(o<p && nums[o]==nums[o-1]){
                            o++;
                        }
                        while(o < p && nums[p]==nums[p+1]){
                            p--;
                        }
                    }
                    else if(sum < target){
                        o++;
                    }
                    else{
                        p--;
                    }
                } 
            }
        }

        return ans;
    }
}