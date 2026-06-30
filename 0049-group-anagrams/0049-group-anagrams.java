// time: O(n * k log k)
// space: O(n*k)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        // sort each string's chars and store it in an array
        Element[] str_arr = new Element[strs.length];
        for(int i=0;i<strs.length;i++){
            char[] chr_arr = strs[i].toCharArray();
            Arrays.sort(chr_arr);
            str_arr[i] = new Element(new String(chr_arr),i);
        }
        // key each elemnt as key ans combine them
        HashMap<String,List<String>> hmap = new HashMap<>();
        for(int i=0;i<str_arr.length;i++){
            if(!hmap.containsKey(str_arr[i].str)){
                hmap.put(str_arr[i].str,new ArrayList<>());
            }
            hmap.get(str_arr[i].str).add(strs[str_arr[i].idx]);
        }
        // combine the hashmap as List of List
        for(String key : hmap.keySet()){
            ans.add(hmap.get(key));
        }

        return ans;
    }
}
class Element{
    String str;
    int idx;

    Element(String str, int idx){
        this.str = str;
        this.idx = idx;
    }
}