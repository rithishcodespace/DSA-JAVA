class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long day = 1;

        HashMap<Integer,Long> map = new HashMap<>(); // day on which task[i] is completed

        for(int i=0;i<tasks.length;i++){
            long prevDay = map.getOrDefault(tasks[i],0L);
            long gap = day-prevDay;

            if(gap <= space && prevDay != 0){
                day += space-gap+1;
            }

            map.put(tasks[i], day);
            day++;
        }

        return day-1;
    }
}