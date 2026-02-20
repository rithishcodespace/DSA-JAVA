class Solution {
    public int minInsertions(String s) {
        int need = 0;
        int insertions = 0;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') {

                if(need % 2 == 1) {
                    insertions++;
                    need--;
                }

                need += 2;
            }
            else {

                need--;

                if(need < 0) {
                    insertions++;
                    need = 1;
                }
            }
        }

        return insertions + need;
    }
}