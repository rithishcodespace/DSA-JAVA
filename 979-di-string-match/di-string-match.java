class Solution {
    public int[] diStringMatch(String s) {
        int l=0, r=s.length();
        int[] arr = new int[s.length()+1];

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'I'){
                arr[i] = l++;
            }
            else{
                arr[i] = r--;
            }

            if(i == s.length()-1){
                if(s.charAt(i) == 'I')arr[i+1] = r--;
                else arr[i+1] = l++;
            }
        }

        return arr;
    }
}