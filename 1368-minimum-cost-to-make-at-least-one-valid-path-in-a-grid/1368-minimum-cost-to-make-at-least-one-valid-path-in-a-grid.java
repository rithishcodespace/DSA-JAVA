// moving from one to next is 0 (if directed)
// if you are breaking the direction 1 

// from each cell try out all directions (either cost will be 1 or 0) with dijkstra

class Solution {
    public int minCost(int[][] grid) {
        int[][] costs = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        minHeap.add(new Element(0, 0, 0));
        costs[0][0] = 0;

        while(!minHeap.isEmpty()){
            Element e = minHeap.poll();
            int r = e.r, c = e.c, cost = e.cost;

            // outdated
            if(cost > costs[r][c])continue;

            // cost = if current cell also directs same direction ? 0 : 1

            // up
            int nr = r-1, nc = c;
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                int Newcost = (grid[r][c] == 4 ? 0 : 1) + cost;
                if(costs[nr][nc] > Newcost){
                    costs[nr][nc] = Newcost;
                    minHeap.add(new Element(nr, nc, Newcost));
                }
            }
            // down
            nr = r+1; nc = c;
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                int Newcost  = (grid[r][c] == 3 ? 0 : 1) + cost;
                if(costs[nr][nc] > Newcost){
                    costs[nr][nc] = Newcost;
                    minHeap.add(new Element(nr, nc, Newcost));
                }
            }
            // left
            nr = r; nc = c-1;
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                int Newcost  = (grid[r][c] == 2 ? 0 : 1) + cost;
                if(costs[nr][nc] > Newcost){
                    costs[nr][nc] = Newcost;
                    minHeap.add(new Element(nr, nc, Newcost));
                }
            }
            // right
            nr = r; nc = c+1;
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                int Newcost  = (grid[r][c] == 1 ? 0 : 1) + cost;
                if(costs[nr][nc] > Newcost){
                    costs[nr][nc] = Newcost;
                    minHeap.add(new Element(nr, nc, Newcost));
                }
            }
        }

        return costs[grid.length-1][grid[0].length-1];
    }
}
class Element{
    int r, c, cost;

    Element(int r, int c, int cost){
        this.r = r;
        this.c = c;
        this.cost = cost;
    }
}