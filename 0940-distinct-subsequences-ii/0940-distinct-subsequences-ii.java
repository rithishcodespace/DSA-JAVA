// dp[i] = number of distinct subsequences (including "")
//         that can be formed using s[0...i]
// prev[i] = prev index of s.charAt(i)
// immediate last index of each character

// goes from n-1 to 0 idx

class Solution {
    int mod=(int)1e9+7;
    public int distinctSubseqII(String s) {
        int[] dp = new int[s.length()];
        int[] prev = new int[s.length()];
        int[] last = new int[26];

        Arrays.fill(dp, -1);
        Arrays.fill(prev, -1);
        Arrays.fill(last, -1);

        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            prev[i] = last[idx];
            last[idx] = i;
        }

        // -1 removes empty subsequence
        return (solve(s.length() - 1, prev, s, dp) - 1 + mod) % mod;
    }
    public int solve(int idx, int[] prev, String s, int[] dp){
        // 1 empty subsequence
        if(idx < 0){ 
            return 1;
        }

        if(dp[idx] != -1)return dp[idx];

        // pick and not pick

        long ans = (2L * solve(idx - 1, prev, s, dp)) % mod;

        // if this character exists before this index, remove the duplicates added by current index
        if(prev[idx] != -1){
            ans = (ans - solve(prev[idx] - 1, prev, s, dp) + mod) % mod;
        }

        return dp[idx] = (int)ans;

    }
}