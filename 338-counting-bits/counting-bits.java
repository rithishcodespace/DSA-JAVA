class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<32;j++){
                if((i & (1 << j)) != 0){
                    bits[i]++;
                }
            }
        }
        return bits;
    }
}