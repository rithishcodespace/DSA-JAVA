class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.freq == b.freq){
                return b.ch-a.ch;
            }
            return b.freq-a.freq;
        });
        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                pq.add(new Pair((char)(i+'a'), freq[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p1 = pq.poll();

            if(sb.length() > 0 && sb.charAt(sb.length()-1) == p1.ch)return "";

            sb.append(p1.ch);

            p1.freq--;

            if(!pq.isEmpty()){
                Pair p2 = pq.poll();

                if(sb.length() > 0 && sb.charAt(sb.length()-1) == p2.ch)return "";

                sb.append(p2.ch);

                p2.freq--;

                if(p2.freq > 0)pq.add(p2);
            }

            if(p1.freq > 0)pq.add(p1);
        }

        return sb.toString();
    }
}
class Pair{
    char ch;
    int freq;

    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}