// two branches open bracket | close bracket
// no.of open <= n && no.of close <= open

// tc: O(2^n), not considering pruned calls
// sc: O(n)

class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve(0, 0, new StringBuilder(), n);
        return list;
    }
    public void solve(int open, int close, StringBuilder sb, int n){
        if(open == n && close == n){
            list.add(sb.toString());
            return;
        }
        if(open > n || close > open){
            return;
        }

        int len = sb.length();

        // open a bracket
        solve(open+1, close, sb.append('('), n);
        // backtrack
        sb.setLength(len);

        // close a bracket
        solve(open, close+1, sb.append(')'), n);
        // backtrack
        sb.setLength(len);
    }
}