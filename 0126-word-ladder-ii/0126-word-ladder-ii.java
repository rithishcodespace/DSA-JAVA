class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){

        List<List<String>> paths = new ArrayList<>();

        // visited, contains - O(1) check for wordList words
        Set<String> dict = new HashSet<>(wordList);

        // destination can't be reached via wordList
        if(!dict.contains(endWord)){
            return paths;
        }

        Map<String, List<String>> parent = new HashMap<>(); // to create connections (graph)

        Map<String, Integer> level = new HashMap<>(); // to mark level of a word and as visited

        Queue<String> q = new LinkedList<>(); // contains current word, not the entire path

        q.add(beginWord);
        level.put(beginWord, 0);

        while(!q.isEmpty()){

            String word = q.poll();
            int currLevel = level.get(word);
            char[] arr = word.toCharArray();

            for(int i = 0; i < arr.length; i++){
                char old = arr[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if (ch == old)continue;

                    arr[i] = ch;

                    String next = new String(arr);

                    if(!dict.contains(next))
                        continue;

                    if(!level.containsKey(next)) {

                        level.put(next, currLevel + 1);
                        q.offer(next);
                        parent.put(next, new ArrayList<>());
                        parent.get(next).add(word);

                    }
                    else if(level.get(next) == currLevel + 1) { // prevents reusable already used words in the path
                        parent.get(next).add(word);
                    }
                }

                arr[i] = old; // backtrack
            }
        }

        if(!level.containsKey(endWord))return paths;

        List<String> path = new ArrayList<>();

        dfs(endWord, beginWord, parent, path, paths);

        return paths;
    }

    // rebuild paths from graph - from endWord to startWord
    public void dfs(String word, String beginWord, Map<String, List<String>> parent, List<String> path, List<List<String>> paths) {

        path.add(word);

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            paths.add(temp);
        } 
        else {
            for (String p : parent.getOrDefault(word, new ArrayList<>())) {
                dfs(p, beginWord, parent, path, paths);
            }
        }

        path.remove(path.size() - 1);
    }
}