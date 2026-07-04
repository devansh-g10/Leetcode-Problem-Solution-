import java.util.*;

class Solution {
    private int ans = Integer.MAX_VALUE;
    private boolean[] visited;
    private List<int[]>[] graph;

    public int minScore(int n, int[][] roads) {
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];

            graph[u].add(new int[]{v, dist});
            graph[v].add(new int[]{u, dist});
        }

        visited = new boolean[n + 1];

        dfs(1);

        return ans;
    }

    private void dfs(int city) {
        visited[city] = true;

        for (int[] edge : graph[city]) {
            int nextCity = edge[0];
            int distance = edge[1];

            ans = Math.min(ans, distance);

            if (!visited[nextCity]) {
                dfs(nextCity);
            }
        }
    }
}