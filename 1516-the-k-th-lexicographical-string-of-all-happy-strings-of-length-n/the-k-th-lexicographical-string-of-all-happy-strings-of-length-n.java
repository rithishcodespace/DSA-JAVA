// use recursion to create happy strings of length n 
// use heap sort to get k'th string
class Solution {
    public String getHappyString(int n, int k) {
        Comparator<StringBuilder> comparator = new Comparator<StringBuilder>(){
            public int compare(StringBuilder a, StringBuilder b){
                int n = Math.min(a.length(),b.length());
                for(int i=0;i<n;i++){
                    int diff = a.charAt(i) - b.charAt(i);
                    if(diff != 0)return diff;
                }
                return a.length()-b.length();
            }
        };
        StringBuilder sb = new StringBuilder();
        PriorityQueue<StringBuilder> minHeap = new PriorityQueue<>(comparator);
        recursion(n,minHeap,sb,' ');
        if(minHeap.size() < k)return "";
        for(int i=1;i<k;i++){
            minHeap.poll();
        }
        return minHeap.poll().toString();
    }
    public void recursion(int n, PriorityQueue<StringBuilder> minHeap, StringBuilder sb, char ch){
        if(ch != ' ')sb.append(ch);
        if(sb.length() == n){
            minHeap.add(new StringBuilder(sb));
            return;
        }

        if(ch == 'a'){
            recursion(n, minHeap, sb, 'b');
            sb.deleteCharAt(sb.length() - 1);
            recursion(n, minHeap, sb, 'c');
            sb.deleteCharAt(sb.length() - 1);
        }
        else if(ch == 'b'){
            recursion(n, minHeap, sb, 'a');
            sb.deleteCharAt(sb.length() - 1);
            recursion(n, minHeap, sb, 'c');
            sb.deleteCharAt(sb.length() - 1);
        }
        else if(ch == 'c'){
            recursion(n, minHeap, sb, 'a');
            sb.deleteCharAt(sb.length() - 1);
            recursion(n, minHeap, sb, 'b');
            sb.deleteCharAt(sb.length() - 1);
        }
        else{
            recursion(n, minHeap, sb, 'a');
            sb.deleteCharAt(sb.length() - 1);
            recursion(n, minHeap, sb, 'b');
            sb.deleteCharAt(sb.length() - 1);
            recursion(n, minHeap, sb, 'c');
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}