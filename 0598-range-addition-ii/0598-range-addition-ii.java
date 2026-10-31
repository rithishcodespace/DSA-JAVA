class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;

        for(int[] op : ops){
            int x = op[0], y = op[1];

            minx = Math.min(minx, x);
            miny = Math.min(miny, y);
        }

        return (ops.length == 0 || ops[0].length == 0) ? m*n : minx * miny;
    }
}