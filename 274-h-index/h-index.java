class Solution {
    public int hIndex(int[] citations) {
        int cnt = 0, h = 0;
        Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--){
            h++;
            if(citations[i] < h)return h-1;
        }
        return citations.length;
    }
}