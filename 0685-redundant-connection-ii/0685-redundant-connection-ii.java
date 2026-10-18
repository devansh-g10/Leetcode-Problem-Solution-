class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1], ds = new int[n + 1];
        Arrays.fill(parent, -1);
        
        int first = -1, second = -1, last = -1;
        
        for (int i = 0; i < n; i++) {
            int p = edges[i][0], c = edges[i][1];
            if (parent[c] != -1) {
                first = parent[c];
                second = i;
                continue;
            }
            parent[c] = i;
            
            int p1 = find(ds, p);
            if (p1 == c) {
                last = i;
            } else {
                ds[c] = p1;
            }
        }
        
        if (last == -1) return edges[second];
        if (second == -1) return edges[last];
        return edges[first];
    }
    
    private int find(int[] ds, int i) {
        return ds[i] == 0 ? i : (ds[i] = find(ds, ds[i]));
    }
}