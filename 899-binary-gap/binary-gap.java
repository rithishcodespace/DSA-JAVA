class Solution {
    public int binaryGap(int n) {
        int prev = -1, max = 0;
        for(int i=0;i<32;i++){
            if(((n>>i) & 1) == 1){
                if(prev == -1){
                    prev = i;
                }
                else{
                    int distance = i-prev;
                    max = Math.max(max,distance);
                }
                prev = i;
            }
        }
        return max;
    }
}