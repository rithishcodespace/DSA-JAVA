// sor logs and queries based on time -> O(LlogL) + O(QlogQ)
// for each query, extend or shrink the window
// ans[i] = n-requests

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(logs, (a,b) -> a[1]-b[1]); // O(nlogn)

        int[][] q = new int[queries.length][2]; // [query, org_index]
        for(int i=0;i<queries.length;i++){
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a,b) -> a[0]-b[0]);

        // sliding window
        int l=0, r=0; // belong to logs
        HashMap<Integer,Integer> hmap = new HashMap<>(); // server, no.of reqs

        for(int i=0;i<queries.length;i++){ // for each query
            int start = q[i][0]-x, end = q[i][0];

            // extend r
            while(r < logs.length && logs[r][1] <= end){
                hmap.put(logs[r][0], hmap.getOrDefault(logs[r][0],0)+1);
                r++;
            }
            // shrink l
            while(l < r && logs[l][1] < start){
                hmap.put(logs[l][0], hmap.getOrDefault(logs[l][0],0)-1);
                if(hmap.get(logs[l][0]) == 0)hmap.remove(logs[l][0]);
                l++;
            }

            ans[q[i][1]] = n - hmap.size();
        }

        return ans;
    }
}