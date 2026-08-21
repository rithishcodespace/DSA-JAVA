// A larger number cannot divide a smaller number (2/5), valid will be 5/2 (curr/prev)
// so we can sort nums to get this order (larger will curr, smaller will be prev)
// instead of prev < curr, we can use curr%prev == 0 to generate LIS

// LDS -> LIS (with new condition)

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int lastIdx = 0, maxLen = 0;

        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];

        for(int i=0;i<dp.length;i++){
            dp[i] = 1;
            hash[i] = i;
        }

        for(int curr=0;curr<nums.length;curr++){
            for(int prev=0;prev<curr;prev++){
                
                if(nums[curr]%nums[prev] == 0){
                    if(dp[prev]+1 > dp[curr]){
                        dp[curr] = dp[prev]+1;
                        hash[curr] = prev;
                    }
                }

            }

            if(dp[curr] > maxLen){
                maxLen = dp[curr];
                lastIdx = curr;
            }
        }

        List<Integer> list = new ArrayList<>();

        while(lastIdx != hash[lastIdx]){
            list.add(nums[lastIdx]);
            lastIdx = hash[lastIdx];
        }
        list.add(nums[lastIdx]);

        Collections.reverse(list);

        return list;
    }
}