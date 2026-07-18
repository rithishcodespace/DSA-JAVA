// Time Complexity  : O(n × 2^n)
// Space Complexity : O(n)          // excluding output
// Space Complexity : O(n × 2^n)    // including output

class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        solve(0, s);
        return ans;
    }

    public void solve(int idx, String s){
        if(idx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx;i<s.length();i++){
            String substr = s.substring(idx, i+1);
            if(isPalindrome(substr)){
                list.add(substr);
                solve(i+1, s);
                // backtrack
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(String str){
        int l=0, r=str.length()-1;

        while(l <= r){
            if(str.charAt(l++) != str.charAt(r--))return false;
        }

        return true;
    }
}