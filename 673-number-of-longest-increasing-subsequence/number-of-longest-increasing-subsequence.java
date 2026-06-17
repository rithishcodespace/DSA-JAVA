// in recursion tree, i used len([]) as parameter, don't use it, if you used that, memoization becomes difficult

class Solution {

    class Element{
        int len;
        int freq;

        Element(int len, int freq){
            this.len = len;
            this.freq = freq;
        }
    }

    public int findNumberOfLIS(int[] nums) {
        Element[][] dp = new Element[nums.length][nums.length + 1];
        int[] ans = solve(0, -1, nums, dp);
        return ans[1];
    }

    public int[] solve(int idx, int prev, int[] nums, Element[][] dp){

        if (idx == nums.length){
            return new int[]{0, 1};
        }

        if (dp[idx][prev + 1] != null) {
            Element e = dp[idx][prev + 1];
            return new int[]{e.len, e.freq};
        }

        // pick
        int pickLen = 0, pickFreq = 0;
        if (prev == -1 || nums[prev] < nums[idx]) {
            int[] pick = solve(idx + 1, idx, nums, dp);
            pickLen = 1 + pick[0]; // len
            pickFreq = pick[1]; // freq
        }

        // not pick
        int[] notPick = solve(idx + 1, prev, nums, dp);

        int len, cnt;

        if (pickLen == notPick[0]) {
            len = pickLen;
            cnt = pickFreq + notPick[1];
        } 
        else if (pickLen > notPick[0]) {
            len = pickLen;
            cnt = pickFreq;
        } 
        else {
            len = notPick[0];
            cnt = notPick[1];
        }

        dp[idx][prev + 1] = new Element(len, cnt);

        return new int[]{len, cnt};
    }
}