class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<dictionary.length;j++){
                if(compare(queries[i], dictionary[j])){
                    list.add(queries[i]);
                    break;
                }
            }
        }
        return list;
    }
    public boolean compare(String str1, String str2){
        int cnt = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i))cnt++;
            if(cnt > 2)return false;
        }
        return true;
    }
}