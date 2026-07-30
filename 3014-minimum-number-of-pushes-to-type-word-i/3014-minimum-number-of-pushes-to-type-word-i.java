class Solution {
    public int minimumPushes(String word) {
        int count = 0, factor = 1, push = 0;

        for(int i=0;i<word.length();i++){
            push += 1*factor;

            count++;
            if(count == 8){
                count = 0;
                factor++;
            }
        }

        return push;
    }
}