// we check in 365 days where both alice and bob on rome

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prefix_sum = new int[12]; // no.of days from jan to current month

        int sum=0, idx=0;
        for(int mon : days){
            sum += mon;
            prefix_sum[idx++] = sum;
        }

        int alice_start = compute_day(prefix_sum, arriveAlice);
        int alice_end = compute_day(prefix_sum, leaveAlice);
        int bob_start = compute_day(prefix_sum, arriveBob);
        int bob_end = compute_day(prefix_sum, leaveBob);

        return Math.max(
            0, Math.min(alice_end, bob_end) - Math.max(alice_start, bob_start)+1
        );
    }
    public int compute_day(int[] prefix_sum, String date){
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));

        return (month == 1 ? 0 : prefix_sum[month-2]) + day;
    }
}