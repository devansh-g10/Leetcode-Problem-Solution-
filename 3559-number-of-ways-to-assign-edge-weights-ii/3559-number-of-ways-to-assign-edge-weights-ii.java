class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int LOG = 17; // 2^17 > 1e5

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        final int n = edges.length + 1;
        int[] ans = new int[queries.length];
        int[] depth = new int[n + 1];
        int[][] parent = new int[LOG][n + 1];
        List<Integer>[] graph = new List[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());

        // Build adjacency list
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // BFS to compute depth and parent[0] (avoids stack overflow for large n)
        Arrays.fill(parent[0], -1);
        int[] queue = new int[n];
        boolean[] visited = new boolean[n + 1];
        int head = 0, tail = 0;
        queue[tail++] = 1;
        visited[1] = true;
        parent[0][1] = 1; // root's parent points to itself
        while (head < tail) {
            int u = queue[head++];
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    depth[v] = depth[u] + 1;
                    parent[0][v] = u;
                    queue[tail++] = v;
                }
            }
        }

        // Build sparse table for binary lifting
        for (int k = 1; k < LOG; k++)
            for (int v = 1; v <= n; v++)
                parent[k][v] = parent[k - 1][parent[k - 1][v]];

        // Answer each query
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (u == v) {
                ans[i] = 0;
            } else {
                int a = lca(u, v, parent, depth);
                int d = depth[u] + depth[v] - 2 * depth[a];
                ans[i] = modPow(2, d - 1);
            }
        }
        return ans;
    }

    private int lca(int u, int v, int[][] parent, int[] depth) {
        // Bring u and v to the same depth
        if (depth[u] < depth[v]) { int t = u; u = v; v = t; }
        for (int k = LOG - 1; k >= 0; k--)
            if (depth[parent[k][u]] >= depth[v])
                u = parent[k][u];
        if (u == v) return u;
        // Lift both until their parents diverge
        for (int k = LOG - 1; k >= 0; k--)
            if (parent[k][u] != parent[k][v]) {
                u = parent[k][u];
                v = parent[k][v];
            }
        return parent[0][u];
    }

    private int modPow(long base, long exp) {
        if (exp < 0) return 0;
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return (int) result;
    }
}