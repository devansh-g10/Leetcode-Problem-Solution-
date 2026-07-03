import java.util.*;

class Solution {

    static class Edge {
        int to;
        long cost;

        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];

        long maxCost = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            long cost = e[2];

            graph[u].add(new Edge(v, cost));
            indegree[v]++;

            maxCost = Math.max(maxCost, cost);
        }

        // Topological Sort
        int[] topo = new int[n];
        int index = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo[index++] = u;

            for (Edge e : graph[u]) {
                if (--indegree[e.to] == 0) {
                    queue.offer(e.to);
                }
            }
        }

        long low = 0;
        long high = maxCost;
        long answer = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canReach(mid, graph, topo, online, k)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) answer;
    }

    private boolean canReach(
        long minScore,
        List<Edge>[] graph,
        int[] topo,
        boolean[] online,
        long k
    ) {

        int n = online.length;

        long INF = k + 1;
        long[] dist = new long[n];

        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] > k) {
                continue;
            }

            // Offline intermediate node
            if (u != 0 && u != n - 1 && !online[u]) {
                continue;
            }

            for (Edge e : graph[u]) {

                int v = e.to;

                // Ignore edge below required score
                if (e.cost < minScore) {
                    continue;
                }

                // Cannot enter offline intermediate node
                if (v != n - 1 && !online[v]) {
                    continue;
                }

                long newCost = dist[u] + e.cost;

                if (newCost <= k && newCost < dist[v]) {
                    dist[v] = newCost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}