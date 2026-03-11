class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0)return 1;
        int result = 0;
        // find number of bits in n
        int temp = n, cnt = 0;
        while(temp > 0){
            temp = temp >> 1;
            cnt++;
        }
        for(int i=0;i<cnt;i++){
            if((n & (1 << i)) != 0){ // 1
                result += 0 * (int)Math.pow(2,i);
            }
            else{
                result += 1 * (int)Math.pow(2,i);
            }
        }
        return result;
    }
}