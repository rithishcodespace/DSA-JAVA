class Solution {
    public List<String> commonChars(String[] words) {
        int[] freq = new int[26];

        for(int i=0;i<words[0].length();i++){
            freq[words[0].charAt(i)-'a']++;
        }

        for(int i=1;i<words.length;i++){

            int[] temp = new int[26];
            for(int j=0;j<words[i].length();j++){
                temp[words[i].charAt(j) - 'a']++;
            }

            for(int j=0;j<26;j++){
                freq[j] = Math.min(freq[j],temp[j]);
            }
        }

        List<String> ans = new ArrayList<>();
        for(int i=0;i<26;i++){
            while(freq[i] > 0){
                ans.add(String.valueOf((char)(i+'a')));
                freq[i]--;
            }
        }

        return ans;
    }
}