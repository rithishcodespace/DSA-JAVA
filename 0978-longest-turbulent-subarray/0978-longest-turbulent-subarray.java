// solve(current idx, expected direction)
// -1 -> no expection
//  1 -> (>)
//  2 -> (<)

class Solution {
    int max = 1;
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 1)return 1;
        for(int i=0;i<arr.length;i++){
            solve(i, -1, arr);
        }
        return max;
    }
    public int solve(int idx, int dir, int[] arr){
        if (idx >= arr.length - 1) {
            return 1;
        }

        int curr_dir = -1;

        if(arr[idx] > arr[idx+1]){
            curr_dir = 1;
        }
        else if(arr[idx] < arr[idx+1]){
            curr_dir = 2;
        }
        
        if(curr_dir == -1)return 1;

        if(dir != -1 && dir != curr_dir)return 1;

        int nextExpected = ((curr_dir == -1 || curr_dir == 1) ? 2 : 1);
        int len = 1+solve(idx+1, nextExpected, arr);

        max = Math.max(max, len);

        return len;
    }
}