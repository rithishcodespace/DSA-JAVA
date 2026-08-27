class Solution {
    public int[] sortArray(int[] nums) {
        merge_sort(0, nums.length-1, nums);
        return nums;
    }
    public void merge_sort(int low, int high, int[] nums){
        if(low >= high){
            return; 
        }
        int mid = (low+high)/2;
        merge_sort(low, mid, nums);
        merge_sort(mid+1, high, nums);
        merge(low, mid, high, nums);
    }
    public void merge(int low, int mid, int high, int[] nums){
        int len1 = mid-low+1;
        int len2 = high-mid;

        int[] left_part = new int[len1];
        int[] right_part = new int[len2];

        // copy values
        int idx = 0;
        for(int i=low;i<=mid;i++){
            left_part[idx++] = nums[i];
        }
        idx=0;
        for(int i=mid+1;i<=high;i++){
            right_part[idx++] = nums[i];
        }

        int p1=0, p2=0, org_idx=low;

        while(p1 < len1 && p2 < len2){
            if(left_part[p1] < right_part[p2]){
                nums[org_idx++] = left_part[p1++];
            }
            else{
                nums[org_idx++] = right_part[p2++];
            }
        }

        while(p1 < len1){
            nums[org_idx++] = left_part[p1++];
        }

        while(p2 < len2){
            nums[org_idx++] = right_part[p2++];
        }
    }
}