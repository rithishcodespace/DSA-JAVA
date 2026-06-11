// find L -> no.of edges
// eg: L -> 3
// no of ways -> 2*2*2 -> 8
// if you explicitly write you will 4 even and 4 odd, which is no.of even = no.of odd = 2^3/2
// so, ans = 2^(L-1)

class Solution {
    int MOD = 1000000007;
    public int assignEdgeWeights(int[][] edges) {
        // create adj_list
        List<List<Integer>> adj_list = new ArrayList<>();

        for(int i=0;i<=edges.length+1;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int key = edges[i][0];
            int val = edges[i][1];

            adj_list.get(key).add(val);
            adj_list.get(val).add(key);
        }

        // peform bfs to find max no.of edges
        int L=0;
        int[] visited = new int[edges.length+2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        visited[1] = 1;

        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            L = Math.max(L,polled[1]);
            for(int i=0;i<adj_list.get(polled[0]).size();i++){
                int node = adj_list.get(polled[0]).get(i);

                if(visited[node] == 0){
                    visited[node] = 1;
                    queue.add(new int[]{node,polled[1]+1});
                }

            }
        }

        return (int)(pow(L-1))%MOD;
    }
    public int pow(int exp){
        long ans = 1;
        long base = 2;

        while(exp > 0){
            if((exp & 1) == 1){
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return (int)ans;
    }
}