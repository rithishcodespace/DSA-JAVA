// after finding mid, find which half (l to mid) or (mid+1 to r) is sorted
// if sorted, check whether target might exists on that range
// if exists, continue binary search inside that range

// tc: O(logn)
// sc: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;

        while(l <= r){
            int mid = l+(r-l)/2;

            if(nums[mid] == target)return mid;

            // check which portion is sorted
            if(nums[l]<=nums[mid]){
                if(nums[l] <= target && nums[mid] >= target){
                    if(nums[mid] == target){
                        return mid;
                    }
                    else if(nums[mid] > target){
                        r=mid-1;
                    }
                    else{
                        l=mid+1;
                    }
                }
                else{
                    l=mid+1;
                }
            }
            else if(nums[mid] < nums[r]){
                if(nums[mid] <= target && nums[r] >= target){
                    if(nums[mid] == target){
                        return mid;
                    }
                    else if(nums[mid] > target){
                        r=mid-1;
                    }
                    else{
                        l=mid+1;
                    }
                }
                else{
                    r=mid-1;
                }
            }
        }   

        return -1;
    }
}