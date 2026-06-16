class Solution {
    public int lengthOfLIS(int[] arr) {
        int max = 1;
        int[] dp = new int[arr.length];
        // each element has minimum len 1
        for(int i=0;i<arr.length;i++){
            dp[i] = 1;
        }
        // check all previous index for each index
        for(int curr=0;curr<arr.length;curr++){
            for(int prev = 0;prev < curr;prev++){
                if(arr[prev] < arr[curr]){
                    dp[curr] = Math.max(1+dp[prev], dp[curr]);
                    max = Math.max(max,dp[curr]);
                }
            }
        }
        return max;
    }
}