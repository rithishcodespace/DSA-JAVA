class Solution {
    public int totalWaviness(int num1, int num2) {
        int waveness = 0;
        for(int i=num1;i<=num2;i++){
            waveness += find(i);
        }
        return waveness;
    }
    public int find(int num){
        int cnt = 0;
        int prev = -1, curr = -1, next = -1;
        while(num > 0){
            curr = num%10;
            num /= 10;
            if(num > 0)next = num%10;
            else next = -1;
            if(prev != -1 && next != -1){
                if(curr > prev && curr > next)cnt++;
                else if(curr < prev && curr < next)cnt++;
            }
            prev = curr;
        }
        return cnt;
    }
}