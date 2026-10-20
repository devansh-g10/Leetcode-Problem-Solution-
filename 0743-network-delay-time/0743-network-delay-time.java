
import java.util.Arrays;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];

        for (int[] row : graph) {
            Arrays.fill(row, -1);
        }

        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for (int i = 1; i <= n; i++) {
            int node = -1;

            // Find the unvisited node with minimum distance
            for (int j = 1; j <= n; j++) {
                if (!visited[j]
                        && (node == -1 || dist[j] < dist[node])) {
                    node = j;
                }
            }

            // Remaining nodes are unreachable
            if (node == -1 || dist[node] == Integer.MAX_VALUE) {
                return -1;
            }

            visited[node] = true;

            // Relax outgoing edges
            for (int neighbor = 1; neighbor <= n; neighbor++) {
                if (graph[node][neighbor] != -1
                        && !visited[neighbor]) {
                    int newDist =
                            dist[node] + graph[node][neighbor];

                    if (newDist < dist[neighbor]) {
                        dist[neighbor] = newDist;
                    }
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}