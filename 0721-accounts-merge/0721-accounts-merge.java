class Solution {
    class DisjointSet {
        int[] parent, rank;
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int findUltimateParent(int node) {
            if (parent[node] == node) return node;
            return parent[node] = findUltimateParent(parent[node]); // Path Compression
        }
        void unionByRank(int u, int v) {
            int pu = findUltimateParent(u);
            int pv = findUltimateParent(v);
            if (pu == pv) return;
            if (rank[pu] < rank[pv]) parent[pu] = pv;
            else if (rank[pv] < rank[pu]) parent[pv] = pu;
            else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();

        // Map emails to account indices and union connected accounts
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (map.containsKey(mail)) {
                    ds.unionByRank(i, map.get(mail));
                } else {
                    map.put(mail, i);
                }
            }
        }

        // Group emails by their ultimate parent index
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<>();
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            int node = ds.findUltimateParent(it.getValue());
            mergedMail[node].add(it.getKey());
        }

        // Format the result: Sort emails and add account names
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // Get name from original account
            temp.addAll(mergedMail[i]);
            result.add(temp);
        }
        return result;
    }
}