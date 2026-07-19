// i will the eat the apples which are gonna rot soon (daily 1)

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int day=0, eaten=0;
        
        // heapify
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> {
            return a.day-b.day;
        });
        
        while(day < apples.length || !heap.isEmpty()){ // on day 0, heap is empty
            // add todays apple, only if withing range, others are remaining apples in basket
            if(day < apples.length && apples[day] > 0)heap.add(new Pair(apples[day], day+days[day]));

            // remove rotten or empty batches
            while(!heap.isEmpty() && (day >= heap.peek().day || heap.peek().apples == 0)){
                heap.poll();
            }

            // eat one apple a day
            if(!heap.isEmpty()){
                heap.peek().apples--;
                eaten++;

                if(heap.peek().apples == 0)heap.poll();
            }

            day++;
        }
        return eaten;
    }
}
class Pair{
    int apples, day;

    Pair(int apples, int day){
        this.apples = apples;
        this.day = day;
    }
}