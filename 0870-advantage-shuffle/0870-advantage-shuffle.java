class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        // sort nums1
        Arrays.sort(nums1);

        // sort nums2, but without modifying it
        Integer[] idx = new Integer[nums2.length]; // primitive can't be sorted with Arrays.sort
        for(int i=0;i<nums2.length;i++)idx[i]=i;
        Arrays.sort(idx, (a,b) -> nums2[b]-nums2[a]);

        // process each's max val and decide whom to take
        int l=0, r=nums1.length-1;
        for(int i : idx){
            if(nums1[r] > nums2[i]){
                ans[i] = nums1[r--];
            }
            else ans[i] = nums1[l++];
        }

        return ans;
    }
}