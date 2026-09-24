class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n+1];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());

        for(int i=0;i<trust.length;i++){
            int u = trust[i][0], v = trust[i][1];

            adj.get(u).add(v);

            trusted[v]++; // to check every other person trusts this person
        }

        // find the person with 0 outgoing edge and check no.of person trust him

        for(int i=1;i<=n;i++){
            if(adj.get(i).size() == 0 && trusted[i] == n-1)return i;
        }

        return -1;
    }
}