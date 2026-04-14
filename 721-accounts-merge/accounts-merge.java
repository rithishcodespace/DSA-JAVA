class Solution {
    int[] parent;
    int[] size;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        HashMap<String, Integer> hmap = new HashMap<>();

        // Map emails and union
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) { // start from 1 (skip name)
                String email = accounts.get(i).get(j);

                if (!hmap.containsKey(email)) {
                    hmap.put(email, i);
                } else { // already an email other person, so join to them
                    union(i, hmap.get(email));
                }
            }
        }

        // Group emails by parent
        HashMap<Integer, List<String>> map = new HashMap<>();

        for (String email : hmap.keySet()) {
            int parentIndex = findParent(hmap.get(email));

            if (!map.containsKey(parentIndex)) {
                map.put(parentIndex, new ArrayList<>());
            }

            map.get(parentIndex).add(email);
        }

        // Build result
        List<List<String>> result = new ArrayList<>();

        for (int key : map.keySet()) {
            List<String> emails = map.get(key);
            Collections.sort(emails);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(key).get(0)); // add name
            temp.addAll(emails);

            result.add(temp);
        }

        return result;
    }

    // DSU find with path compression
    public int findParent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    // DSU union by size
    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}