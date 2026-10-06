// for each window of size total, count no.of 0's

class Solution {
    public int minSwaps(int[] nums) {
        // count total no.of ones
        int total = 0, min=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            total += nums[i];
        }

        // wrap the array once again
        int[] arr = new int[nums.length+total+1];
        for(int i=0;i<nums.length+total+1;i++){
            arr[i] = nums[i%nums.length];
        }

        // find min no.of swaps
        int l=0, r=0, ones=0;
        while(r<arr.length){
            ones += arr[r];

            if(r >= total-1 ){
                int zeros = total-ones;
                min = Math.min(zeros, min);

                ones -= arr[l++];
            }

            r++;
        }

        return min;
    }
}