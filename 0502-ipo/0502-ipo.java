class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // heapify
        PriorityQueue<Pair> capitalHeap = new PriorityQueue<>((a, b) -> a.capital-b.capital); // min
        PriorityQueue<Pair> profitHeap = new PriorityQueue<>((a, b) -> b.profit-a.profit); // max

        // add all capitals to make in increasing order
        for(int i=0;i<capital.length;i++){
            capitalHeap.add(new Pair(capital[i], profits[i]));
        }

        // pick all pairs with current affordable capital and put them into profitHeap (them pick highest among them)
        while(k-- > 0){
            while(!capitalHeap.isEmpty() && w >= capitalHeap.peek().capital){
                profitHeap.add(capitalHeap.poll());
            }

            if(profitHeap.isEmpty()){
                break; // no projects to pick
            }

            w += profitHeap.poll().profit; // pick profit with highest profit among current w value
        }

        return w;
    }
}
class Pair{
    int capital, profit;

    Pair(int capital, int profit){
        this.capital = capital;
        this.profit = profit;
    }
}