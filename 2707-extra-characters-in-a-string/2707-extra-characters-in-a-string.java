class Solution {

    Integer[] dp;
    HashMap<String, Boolean> map = new HashMap<>();

    public int minExtraChar(String s, String[] dictionary) {
        dp = new Integer[s.length()];
        // save the strings in dictionary
        for(String str : dictionary){
            map.put(str, true);
        }

        return solve(0, s);        
    }

    public int solve(int start, String s){
        if(start == s.length()){
            return 0;
        }

        if(dp[start] != null)return dp[start];

        // not pick
        int result = 1 + solve(start+1, s);

        // check if all substring from idx present in dictionary
        for(int end=start;end<s.length();end++){
            String sub = s.substring(start,end+1);
            if(map.containsKey(sub)){
                result = Math.min(result, solve(end+1, s));
            }
        }

        return dp[start] = result;
    }
}