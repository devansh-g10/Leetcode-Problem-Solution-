class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList();
        for (int i = 0; i < n + 1; i++)
            adj.add(new ArrayList<>());
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new int[] { w, v });
        }
        int[] weights = new int[n + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        weights[k] = 0;
        pq.offer(new int[] { 0, k });
        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int weight = current[0];
            int node = current[1];

            if (weight > weights[node])
                continue;

            for (int[] neighbour : adj.get(node)) {
                int neighbourWeight = neighbour[0];
                int neighbourNode = neighbour[1];

                if (weight + neighbourWeight < weights[neighbourNode]) {
                    weights[neighbourNode] = weight + neighbourWeight;
                    pq.offer(new int[] { weight + neighbourWeight, neighbourNode });
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (weights[i] == Integer.MAX_VALUE)
                return -1;

            maxTime = Math.max(maxTime, weights[i]);
        }

        return maxTime;
    }
}