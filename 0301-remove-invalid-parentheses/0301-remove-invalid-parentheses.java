// Generate possibilities by pick / don't-pick, keep the valid strings, and return the valid strings with maximum length.

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        TreeMap<Integer, Set<String>> map = new TreeMap<>();

        find_parenthesis(0, 0, new StringBuilder(), s, map);

        return new ArrayList<>(map.get(map.lastKey()));
    }
    public void find_parenthesis(int idx, int open, StringBuilder sb, String s, TreeMap<Integer, Set<String>> map){
        if(idx == s.length()){
            if(open == 0){
                if(!map.containsKey(sb.length()))map.put(sb.length(), new HashSet<>());
                map.get(sb.length()).add(sb.toString());
            }
            return;
        }

        int len = sb.length();

        // pick
        if(s.charAt(idx) == '('){
            sb.append('(');
            find_parenthesis(idx+1, open+1, sb, s, map);
        }
        else if(s.charAt(idx) == ')'){
            if(open > 0){
                sb.append(')');
                find_parenthesis(idx+1, open-1, sb, s, map);
            }
        }
        else{
            sb.append(s.charAt(idx));
            find_parenthesis(idx + 1, open, sb, s, map);
        }

        // backtrack
        sb.setLength(len);

        // not pick
        if(s.charAt(idx) == '(' || s.charAt(idx) == ')')find_parenthesis(idx+1, open, sb, s, map);

        // backtrack
        sb.setLength(len);
    }
}