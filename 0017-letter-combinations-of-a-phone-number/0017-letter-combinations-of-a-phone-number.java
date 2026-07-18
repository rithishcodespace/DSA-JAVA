class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String[] map = {"none","none","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(0, digits, map, new StringBuilder());
        return ans;
    }
    public void solve(int idx, String digits, String[] map, StringBuilder sb){
        if(idx == digits.length()){
            if(!sb.isEmpty())ans.add(sb.toString());
            return;
        }

        int key = digits.charAt(idx)-'0';

        int ans = 0;
        for(int i=0;i<map[key].length();i++){
            sb.append(map[key].charAt(i));
            solve(idx+1, digits, map, sb);
            // backtrack
            sb.deleteCharAt(sb.length()-1);
        }
    }
}