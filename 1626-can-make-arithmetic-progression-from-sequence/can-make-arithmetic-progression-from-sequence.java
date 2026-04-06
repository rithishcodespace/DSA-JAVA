class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int prev = arr[0], prevDiff = -1;
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int diff = curr-prev;
            if(prevDiff != -1 && prevDiff != diff){
                return false;
            }
            prev = curr;
            prevDiff = diff;
        }
        return true;
    }
}