class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] visited = new int[n*n + 1];
        Queue<Square> q = new LinkedList<>();
        visited[1] = 1;

        q.add(new Square(1, 0));

        while(!q.isEmpty()){
            Square sq = q.poll();
            int dist = sq.dist, val = sq.val;

            if(val == n*n){
                return dist;
            }

            for(int i=1;i<=6;i++){
                int newSq = val+i;

                if(newSq <= n*n){
                    int nr = n - 1 - (newSq - 1) / n;
                    int nc = (newSq - 1) % n;
                    
                    if ((n - 1 - nr) % 2 == 1) { // alternation rows
                        nc = n - 1 - nc;
                    }
                    
                    // check for ladders and snakes - dont look, pick them once
                    if(board[nr][nc] != -1){
                        newSq = board[nr][nc];

                        nr = n - 1 - (newSq - 1) / n;
                        nc = (newSq - 1) % n;

                        if ((n - 1 - nr) % 2 == 1) {
                            nc = n - 1 - nc;
                        }
                    }

                    if(visited[newSq] == 0){
                        q.add(new Square(newSq, dist+1));
                        visited[newSq] = 1;
                    }
                }

            }

        }

        return -1;
    }
}
class Square{
    int val, dist;

    Square(int val, int dist){
        this.val = val;
        this.dist = dist;
    }
}