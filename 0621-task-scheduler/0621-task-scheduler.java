class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;

        // count the frequency of each task
        int[] freq = new int[26];

        for(char task : tasks){
           freq[task-'A']++;
        }

        // heapify
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                pq.add(freq[i]);
            }
        }

        // queue to store task count and their next available time
        Queue<int[]> cooldown = new LinkedList<>();

        // execute unitl task's available
        while(!pq.isEmpty() || !cooldown.isEmpty()){
            time++;

            // task's whose cooldown over come available again
            while(!cooldown.isEmpty() && time == cooldown.peek()[1]){
                pq.add(cooldown.poll()[0]);
            }
            
            // if task avail
            if(!pq.isEmpty()){
                int count = pq.poll();
                count--;

                if(count > 0){
                    cooldown.add(new int[] {count, time+n+1});
                }
            }
        }

        return time;
    }
}