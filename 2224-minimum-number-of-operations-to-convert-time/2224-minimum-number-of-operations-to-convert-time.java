class Solution {
    public int convertTime(String current, String correct) {
        int op = 0;

        int curr = getMins(current);
        int corr = getMins(correct);

        while(curr+60 <= corr){
            curr += 60;
            op++;
        }
        while(curr+15 <= corr){
            curr += 15;
            op++;
        }
        while(curr+5 <= corr){
            curr += 5;
            op++;
        }
        while(curr+1 <= corr){
            curr += 1;
            op++;
        }

        return op;
    }
    public int getMins(String time){
        int mins = 0;
        String[] arr = time.split(":");
        
        mins += Integer.parseInt(arr[0]) * 60;
        mins += Integer.parseInt(arr[1]);

        return mins;
    }
}