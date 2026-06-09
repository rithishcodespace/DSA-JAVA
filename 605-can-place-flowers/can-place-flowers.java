class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length;i++){
            int prev = (i > 0) ? flowerbed[i-1] : -1;
            int curr = flowerbed[i];
            int next = (i < flowerbed.length-1) ? flowerbed[i+1] : -1;

            if(prev != 1 && next != 1 && curr == 0){
                n--;
                flowerbed[i] = 1;
            }

            if(n == 0)break;
        } 

        return (n <= 0) ? true : false;
    }
}