// binary search

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(list.isEmpty() || list.get(list.size()-1) < num){
                list.add(num);
            }
            else{ // instead of creating new list from scratch, place num in lower bound index
                int idx = lowerBound(0, list.size()-1, num, list);
                list.set(idx, num);
            }        
        }

        return list.size();
    }
    // lb => index >= num
    public int lowerBound(int l, int r, int target, List<Integer> list){
        int idx = 0;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(list.get(mid) >= target){
                idx=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return idx;
    }
}