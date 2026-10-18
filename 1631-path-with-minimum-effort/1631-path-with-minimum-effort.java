// dijkstra - instead of adding distances, store differences

class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public int minimumEffortPath(int[][] heights) {
        int[][] distance = new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) -> a.diff-b.diff);
        minHeap.add(new Element(0, 0, 0));
        distance[0][0] = 0;

        while(!minHeap.isEmpty()){
            Element e = minHeap.poll();
            int r = e.r, c = e.c, diff = e.diff;

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length){
                    int newDiff = Math.abs(heights[r][c]-heights[nr][nc]);
                    int newEffort = Math.max(diff, newDiff);
                    if(distance[nr][nc] > newEffort){
                        distance[nr][nc] = newEffort;
                        minHeap.add(new Element(nr, nc, newEffort));
                    }
                }
            }
        }

        return distance[heights.length-1][heights[0].length-1];
    }
}
class Element{
    int r, c, diff;

    Element(int r, int c, int diff){
        this.r = r;
        this.c = c;
        this.diff = diff;
    }
}