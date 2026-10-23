class Trie {
    Node root;
    
    Trie(){
        root = new Node();    
    }
    
    public void insert(String str){
        Node curr = root;
        for(int i=0;i<str.length();i++){
            int idx = str.charAt(i)-97;
            if(curr.links[idx] == null){
                curr.links[idx] = new Node();
            }
            curr = curr.links[idx];
            
            // mark end of String
            if(i == str.length()-1)curr.flag=true;
        }
    }
    
    public boolean search(String str){
        Node curr = root;
        for(int i=0;i<str.length();i++){
            int idx = str.charAt(i)-97;
            if(curr.links[idx] == null)return false;
            curr = curr.links[idx];
        }
        return curr.flag;
    }
    
    public boolean startsWith(String prefix){
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i)-97;
            if(curr.links[idx] == null)return false;
            curr = curr.links[idx];
        }
        return true;
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
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */