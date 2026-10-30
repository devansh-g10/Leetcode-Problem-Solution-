class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        int m = edges.length;
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] next = new int[m];
        for (int i = 0; i < m; i++) {
            next[i] = head[edges[i][0]];
            head[edges[i][0]] = i;
        }
        char[] lab = labels.toCharArray();
        long[] dist = new long[n * k];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[0] = 0;
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int state = (int) cur[1];
            if (d > dist[state]) continue;
            int u = state / k;
            int run = state % k + 1;
            if (u == n - 1) return (int) d;
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = edges[e][1];
                int nr = lab[v] == lab[u] ? run + 1 : 1;
                if (nr > k) continue;
                int ns = v * k + nr - 1;
                long nd = d + edges[e][2];
                if (nd < dist[ns]) {
                    dist[ns] = nd;
                    pq.offer(new long[]{nd, ns});
                }
            }
        }
        return -1;
    }
}