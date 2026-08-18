class Solution {
    public int largestInteger(int[] nums, int k) {
        int l=0, r=0;
        int maxVal = -1;
        int[] arr = new int[51];
        Arrays.fill(arr, Integer.MAX_VALUE);
        
        while(r<nums.length){

            while(r-l+1 > k){
                l++;
            }

            if(r-l+1 == k){
                HashSet<Integer> set = new HashSet<>();
                for(int i=l;i<=r;i++){
                    set.add(nums[i]);
                }

                for(int x : set){
                    if(arr[x] == Integer.MAX_VALUE)arr[x] = 0;
                    arr[x]++;
                }
            }

            r++;
        }

        for(int i=0;i<51;i++){
            if(arr[i] <= 1){
                maxVal = Math.max(maxVal, i);
            }
        }

        return maxVal;
    }
}