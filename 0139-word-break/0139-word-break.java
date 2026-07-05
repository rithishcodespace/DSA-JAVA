// after splitting every word should be in the dictionary
// try to split at current idx

class Solution {
    HashMap<String, Boolean> dp = new HashMap<>(); 
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(0, new StringBuilder(), s, wordDict);
    }
    public boolean solve(int idx, StringBuilder sb, String s, List<String> wordDict){
        if(idx == s.length()){
           // sb is non-empty, it means there's an unfinished word that was never validated.
           return sb.length() == 0 ? true : false;
        }

        // dp part
        String key = idx+sb.toString();
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        int len = sb.length();
        boolean split = false, not_split = false;

        // save the string through the path
        sb.append(s.charAt(idx)); 

        // not split at this point
        not_split = solve(idx+1, sb, s, wordDict);

        // split at this point
        if(wordDict.contains(sb.toString())){ // check the string before split exits in dictionary
            // start fresh, after splitting (to get right side string) -> pass fresh sb
            split = solve(idx+1, new StringBuilder(), s, wordDict);
        }
        else split = solve(idx+1, sb, s, wordDict);


        // backtrack
        sb.setLength(len);

        dp.put(key, (split || not_split));

        return dp.get(key);
    }
}