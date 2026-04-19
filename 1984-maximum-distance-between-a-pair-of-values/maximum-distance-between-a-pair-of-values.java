class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for(int i=0;i<nums1.length;i++){
            int dist = bs(i,nums2,nums1[i]);
            max = Math.max(max, dist);
        }
        return max;
    }
    public int bs(int start_idx, int[] nums2, int x){
        int l = start_idx, r = nums2.length-1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(nums2[mid] < x){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return (l-1)-start_idx;
    }
}