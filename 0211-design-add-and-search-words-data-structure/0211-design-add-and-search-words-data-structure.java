class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-97;
            if(word.charAt(i) == '.'){
                
            }
            if(curr.links[idx] == null)curr.links[idx] = new Node();
            curr = curr.links[idx];

            // mark end of word
            if(i == word.length()-1)curr.flag = true;
        }
    }
    
    public boolean search(String word) {
        return dfs(root, 0, word);
    }

    public boolean dfs(Node curr, int idx, String word){
        if(idx == word.length())return curr.flag;

        // call all child nodes and continue search
        if(word.charAt(idx) == '.'){
            for(int j=0;j<26;j++){
                if(curr.links[j] != null){
                    if(dfs(curr.links[j], idx+1, word))return true;
                }
            }
        }
        else{
            int i = word.charAt(idx)-97;
            if(curr.links[i] == null)return false;
            
            if(dfs(curr.links[i], idx+1, word))return true;
        }

        return false;
    }
}

class Node{
    boolean flag;
    Node[] links;

    Node(){
        flag = false;
        links = new Node[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */