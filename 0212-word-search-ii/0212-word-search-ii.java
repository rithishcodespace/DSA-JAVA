// dfs from each cell to generate strings
// trie to check whether the generated string needs to be continued or stop (trie of words)

class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();

        // create trie with words
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        // dfs from every cell
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                trie.compute(i, j, list, board);
            }
        }

        return list;
    }
}

class Trie{
    
    Node root;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    
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
    
    public void compute(int r, int c, List<String> list, char[][] board){
        StringBuilder sb = new StringBuilder();
        int[][] visited = new int[board.length][board[0].length];
        dfs(r, c, sb, visited, board, list, root);
    }

    public void dfs(int r, int c, StringBuilder sb, int[][] visited, char[][] board, List<String> list, Node curr){
        int idx = board[r][c]-97;

        if(curr.links[idx] != null){
            curr = curr.links[idx]; // move to curr
            visited[r][c] = 1;
            sb.append(board[r][c]);

            // add to answer
            if(curr.flag){
                list.add(sb.toString());
                curr.flag = false; // to avoid duplicates
            }

            for(int[] d : dir){
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && visited[nr][nc] == 0){
                    dfs(nr, nc, sb, visited, board, list, curr);
                }
            }

            // backtrack
            sb.deleteCharAt(sb.length()-1);
            visited[r][c] = 0;
        }
        else return;
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