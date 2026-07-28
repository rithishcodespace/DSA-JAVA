class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length;i++){
            int l=i+1, r=nums.length-1;

            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                int diff = Math.abs(target-sum), ans_diff = Math.abs(target-ans);
                
                if(sum == target){
                    return sum;
                }
                else if(sum < target){
                    l++;
                }
                else{
                    r--;
                }

                if(ans_diff > diff){
                    ans = sum;
                    ans_diff = diff;
                }
            }
        }

        return ans;
    }
}