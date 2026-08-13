// convert first 6 to 9 (from right to left)

class Solution {
    public int maximum69Number (int num) {
        int val = 0;
        char[] arr = String.valueOf(num).toCharArray();

        for(int i=0;i<arr.length;i++){
            if(arr[i] == '6'){
                arr[i] = '9';
                break;
            }
        }        

        for(int i=0;i<arr.length;i++){
            val = val * 10 + (arr[i] - '0');
        }

        return val;
    }
}