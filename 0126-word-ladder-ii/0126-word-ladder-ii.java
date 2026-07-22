class Solution {

    List<List<String>> paths = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>();
        for(String str : wordList){
            dict.add(str);
        }
        if(!dict.contains(endWord))return paths;

        HashMap<String, Integer> levelMap = new HashMap<>();
        HashMap<String, List<String>> parentMap = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        levelMap.put(beginWord, 0);

        while(!queue.isEmpty()){
            String word = queue.poll();

            if(word.equals(endWord)){
                continue;
            }

            char[] arr = word.toCharArray();
            int currLevel = levelMap.get(word);

            for(int i=0;i<arr.length;i++){
                char org = arr[i];
                for(int j=0;j<26;j++){
                    arr[i] = ((char)(j+97));
                    String newWord = new String(arr);
                    if(!dict.contains(newWord)){
                        continue;
                    }
                    else if(!levelMap.containsKey(newWord)){
                        queue.add(newWord);
                        levelMap.put(newWord, currLevel+1);
                        parentMap.put(newWord, new ArrayList<>());
                        parentMap.get(newWord).add(word);
                    }
                    else if(currLevel+1 == levelMap.get(newWord)){
                        parentMap.get(newWord).add(word);
                    }
                }
                arr[i] = org;

            }
        }

        if(!levelMap.containsKey(endWord))return paths;

        buildPaths(endWord, beginWord, parentMap, new ArrayList<>());

        return paths;
    }
    public void buildPaths(String word, String startWord, Map<String,List<String>> parentMap, List<String> path){
        path.add(word);

        if(word == startWord){
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            paths.add(temp);
        }
        else{
            for(String parent : parentMap.getOrDefault(word, new ArrayList<>())){
                buildPaths(parent, startWord, parentMap, path);
            }
        }

        // backtrack
        path.remove(path.size()-1);
    }
}