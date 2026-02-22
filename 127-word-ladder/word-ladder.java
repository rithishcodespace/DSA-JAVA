// bfs
// to maintain visited remove the word from the hashset
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // save words in set to check CONTAINS and VISITED
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        if (!set.contains(endWord)) return 0;
        // start bfs
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            StringBuilder sb = new StringBuilder(pair.word);
            // replace each character from a-z
            for(int i=0;i<sb.length();i++){
                char current_ch = sb.charAt(i);
                for(int j=0;j<26;j++){
                    char ch = (char)(j+97);
                    if(ch == current_ch)continue;
                    sb.setCharAt(i,ch);
                    if(sb.toString().equals(endWord)){
                        return pair.level+1;
                    }
                    // check whether set contains this word
                    if(set.contains(sb.toString())){
                        // add the string to queue
                        queue.add(new Pair(sb.toString(),pair.level+1));
                        // remove the string from set (for visited)
                        set.remove(sb.toString());
                    }
                }
                sb.setCharAt(i,current_ch); // backtrack to original character
            }
        }
        return 0;
    }
}
class Pair{
    String word;
    int level;

    Pair(String word, int level){
        this.word = word;
        this.level = level;
    }
}