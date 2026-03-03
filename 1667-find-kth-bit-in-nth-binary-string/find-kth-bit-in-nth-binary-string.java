class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1)return '0';
        StringBuilder prev = new StringBuilder();
        prev.append('0');
        StringBuilder ans = new StringBuilder();
        recursion(prev,2,n,ans);
        return ans.charAt(k-1);
    }
    public void recursion(StringBuilder prev, int i, int n, StringBuilder ans){
        if(i > n){
            ans.append(prev);
            return;
        }
        StringBuilder curr = new StringBuilder(prev);
        curr.append("1");
        curr.append(reverse(invert(prev)));
        recursion(curr, i+1, n, ans);
    }
    public StringBuilder reverse(StringBuilder sb){
        StringBuilder rev = new StringBuilder();
        for(int i=sb.length()-1;i>=0;i--){
            rev.append(sb.charAt(i));
        }
        return rev;
    }
    public StringBuilder invert(StringBuilder sb){
        StringBuilder inv = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) == '0'){
                inv.append('1');
            }
            else{
                inv.append('0');
            }
        }
        return inv;
    }
}