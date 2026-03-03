class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] distance = new int[heights.length][heights[0].length];
        for(int i=0;i<distance.length;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        dijkstra(heights,distance);
        return distance[heights.length - 1][heights[0].length - 1];
    }
    public void dijkstra(int[][] heights, int[][] distance){
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        minHeap.add(new Element(0,0,0));
        while(!minHeap.isEmpty()){
            Element element = minHeap.poll();
            if(element.dist > distance[element.row][element.col]) continue;

            int row = element.row;
            int col = element.col;

            // up
            if(row-1 >= 0){
                int difference = Math.abs(heights[row][col]-heights[row-1][col]);
                int newEffort = Math.max(distance[element.row][element.col],difference);
                if(newEffort < distance[row-1][col]){
                    distance[row-1][col] = newEffort;
                    minHeap.add(new Element(row-1,col,newEffort));
                }
            }
            // down
            if(row+1 < heights.length){
                int difference = Math.abs(heights[row][col]-heights[row+1][col]);
                int newEffort = Math.max(distance[element.row][element.col],difference);
                if(newEffort < distance[row+1][col]){
                    distance[row+1][col] = newEffort;
                    minHeap.add(new Element(row+1,col,newEffort));
                }
            }
            // left
            if(col-1 >= 0){
                int difference = Math.abs(heights[row][col]-heights[row][col-1]);
                int newEffort = Math.max(distance[element.row][element.col],difference);
                if(newEffort < distance[row][col-1]){
                    distance[row][col-1] = newEffort;
                    minHeap.add(new Element(row,col-1,newEffort));
                }
            }
            // right
            if(col+1 < heights[0].length){
                int difference = Math.abs(heights[row][col]-heights[row][col+1]);
                int newEffort = Math.max(distance[element.row][element.col],difference);
                if(newEffort < distance[row][col+1]){
                    distance[row][col+1] = newEffort;
                    minHeap.add(new Element(row,col+1,newEffort));
                }
            }
        }
    }
}
class Element{
    int row;
    int col;
    int dist;

    Element(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}