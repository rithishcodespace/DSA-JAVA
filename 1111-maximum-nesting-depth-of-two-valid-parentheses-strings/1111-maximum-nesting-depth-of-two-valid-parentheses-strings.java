class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int open = 0; // depth
        int[] ans = new int[seq.length()];

        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i) == '('){
                open++;
                ans[i] = open%2;
            }
            else{
                ans[i] = open%2;
                open--;
            }
            
        }

        return ans;
    }
}