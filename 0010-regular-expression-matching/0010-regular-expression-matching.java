// "."     -> you can match with any character
// "<ch>*" -> you can repeat the <ch> 0 or more times (here 0 means the whole "a*" will be disappered) 
// so whenever you encounted <ch>*, you have 2 choices, pick <ch>, not pick <ch>

class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(0, 0, s, p);
    }
    public boolean dfs(int i, int j, String s, String p){
        // base case 
        if(i >= s.length() && j >= p.length()){ // matched
            return true;
        }
        if(j >= p.length()){ // pattern matched, but the actual string has leftout characters
            return false;
        }
        

        // check if current characters (i and j) matches
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // if (j+1)'th char is a "*"
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            // don't use * (j = j+2)
            boolean d_use = dfs(i, j+2, s, p); // use skipped (<ch>*)
            // use * (i = i+1)
            boolean use = match && dfs(i+1, j, s, p); // consume only it is matched

            return d_use || use;
        }
        
        if(match){ // j does not have * in j+1
            return dfs(i+1, j+1, s, p);
        }

        return false;
    }
}