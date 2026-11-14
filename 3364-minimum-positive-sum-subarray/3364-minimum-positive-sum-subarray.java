class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;

        for(int i=l;i<=r;i++){
            min = Math.min(min, func(i, nums));
        }

        return (min <= 0 || min == Integer.MAX_VALUE) ? -1 : min;
    }
    public int func(int size, List<Integer> nums){
        int l=0, r=0, sum=0, min=Integer.MAX_VALUE;

        while(r < nums.size()){
            if(r < size){
                sum += nums.get(r);
            }
            else{
                if(sum > 0)min = Math.min(min, sum);
                sum -= nums.get(l++);
                sum += nums.get(r);
            }

            r++;
        }

        if(sum > 0)min = Math.min(min, sum);

        return min;
    }
}