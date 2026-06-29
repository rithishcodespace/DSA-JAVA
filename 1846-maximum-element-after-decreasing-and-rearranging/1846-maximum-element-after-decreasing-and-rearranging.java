class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 1;
        for(int i=0;i<arr.length;i++){
            if(i == 0){
                if(arr[i] != 1){
                    arr[i] = 1;
                }
            }
            else{
                int diff = Math.abs(arr[i-1]-arr[i]);
                if(diff > 1){
                    arr[i] = arr[i-1]+1;
                }
            }
            
            max = Math.max(max, arr[i]);
        }       

        return max;
    }
}