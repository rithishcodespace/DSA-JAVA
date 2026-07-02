// n = 5 (4+3+2+1) = 10 -> n(n-1)/2 = 10

// tc: O(n)
// sc: O(n)

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long cnt = 0;
        HashMap<Double,Integer> hmap = new HashMap<>();

        for(int i=0;i<rectangles.length;i++){
            double ratio = (double)rectangles[i][0]/rectangles[i][1];
            hmap.put(ratio,hmap.getOrDefault(ratio,0)+1);
        }

        // n(n-1)/2
        for(double key : hmap.keySet()){
            long n = hmap.get(key);
            cnt += (n*(n-1))/2;
        }

        return cnt;
    }
}