class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int front = -1, back = -1, n = words.length;
        for(int i=0;i<words.length;i++){
            int idx = (startIndex+i)%n;
            if(words[idx].equals(target)){
                front=i;
                break;
            }
        }
        for(int i=0;i<words.length;i++){
            int idx = (startIndex-i+n)%n;
            if(words[idx].equals(target)){
                back=i;
                break;
            }
        }
        if(front == -1 && back == -1)return -1;
        return Math.min(front, back);
    }
}