class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        int ans1 = 0, ans2 = 0;

        HashSet<Integer> one = new HashSet<>();
        HashSet<Integer> two = new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            one.add(nums1[i]);
        }

        for(int j=0;j<nums2.length;j++){
            two.add(nums2[j]);
        }

        for(int i=0;i<nums1.length;i++){
            if(two.contains(nums1[i]))ans1++;
        }

        for(int j=0;j<nums2.length;j++){
            if(one.contains(nums2[j]))ans2++;
        }

        int[] ans = {ans1,ans2};

        return ans;
    }
}