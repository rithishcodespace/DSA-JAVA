class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        Arrays.sort(nums1);

        Integer[] idx = new Integer[nums1.length];
        for(int i=0;i<nums1.length;i++)idx[i]=i;

        Arrays.sort(idx, (a,b) -> nums2[b]-nums2[a]);

        int l=0, r=nums1.length-1;

        for(int i : idx){
            if(nums1[r] > nums2[i]){
                res[i] = nums1[r--];
            }
            else{
                res[i] = nums1[l++];
            }
        }

        return res;
    }
}