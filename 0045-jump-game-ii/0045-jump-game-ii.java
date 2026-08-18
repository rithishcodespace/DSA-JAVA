class Solution {
    public int jump(int[] nums) {
        int furthestEnd = 0, currentEnd = 0, jump = 0;
        for(int i=0;i<nums.length-1;i++){
            int reach = i+nums[i];
            furthestEnd = Math.max(reach, furthestEnd);

            if(i == currentEnd){
                currentEnd = furthestEnd;
                jump++;
            }
        }

        return jump;
    }
}