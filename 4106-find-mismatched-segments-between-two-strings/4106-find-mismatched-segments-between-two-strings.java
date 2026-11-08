class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                str1.append(s1.charAt(i));
                str2.append(s2.charAt(i));
            }
            else{
                if(str1.length() > 0){
                    List<String> list = new ArrayList<>();
                    list.add(str1.toString());
                    list.add(str2.toString());
                    ans.add(list);

                    str1.setLength(0);
                    str2.setLength(0);
                }
            }
        }

        // leftout
        if(str1.length() > 0){
            List<String> list = new ArrayList<>();
            list.add(str1.toString());
            list.add(str2.toString());

            ans.add(list);
            str1.setLength(0);
            str2.setLength(0);
        }

        return ans;
    }
}