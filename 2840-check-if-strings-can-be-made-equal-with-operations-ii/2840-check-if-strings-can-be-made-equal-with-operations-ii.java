// Time Complexity: O(nlogn)
// Space Complexity: O(n)


class Solution {
    public boolean checkStrings(String s1, String s2) {
        List<Character> e_s1 = new ArrayList<>();
        List<Character> o_s1 = new ArrayList<>();
        List<Character> e_s2 = new ArrayList<>();
        List<Character> o_s2 = new ArrayList<>();

        for(int i=0;i<s1.length();i++){
            if(i%2 == 0){
                e_s1.add(s1.charAt(i));
            }
            else{
                o_s1.add(s1.charAt(i));
            }
        }
        for(int i=0;i<s1.length();i++){
            if(i%2 == 0){
                e_s2.add(s2.charAt(i));
            }
            else{
                o_s2.add(s2.charAt(i));
            }
        }

        Collections.sort(e_s1);
        Collections.sort(o_s1);
        Collections.sort(e_s2);
        Collections.sort(o_s2);

        for(int i=0;i<e_s1.size();i++){
            if(e_s1.get(i) != e_s2.get(i))return false;
        }
        for(int i=0;i<o_s1.size();i++){
            if(o_s1.get(i) != o_s2.get(i))return false;
        }

        return true;
    }
}