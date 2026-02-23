class Solution {
    public boolean hasAllCodes(String s, int k) {
        int l=0, r = 0;
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while(r < s.length()){
            sb.append(s.charAt(r));
            if(r-l+1 > k){
                sb.deleteCharAt(0);
                l++;
            }
            if(r-l+1 == k){
                set.add(sb.toString());
            }
            r++;
        }
        return (set.size() == (int)Math.pow(2,k));
    }
}