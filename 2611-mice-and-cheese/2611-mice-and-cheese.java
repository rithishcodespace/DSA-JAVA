class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int rewards = 0;

        PriorityQueue<Reward> pq = new PriorityQueue<>((a,b) -> {
            int gain1 = a.m1-a.m2;
            int gain2 = b.m1-b.m2;

            return gain2-gain1;
        });

        for(int i=0;i<reward1.length;i++){
            pq.add(new Reward(reward1[i], reward2[i]));
        }

        // consume first k (for reward1)
        while(k-- > 0){
            rewards += pq.poll().m1;
        }

        // consume left out
        while(!pq.isEmpty()){
            rewards += pq.poll().m2;
        }

        return rewards;
    }
}
class Reward{
    int m1, m2;

    Reward(int m1, int m2){
        this.m1 = m1;
        this.m2 = m2;
    }
}