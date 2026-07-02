class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, startHealth});

        boolean[][][] visited = new boolean[m][n][health + 1];
        visited[0][0][startHealth] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int h = cur[2];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int nextHealth = h - grid.get(nr).get(nc);

                if (nextHealth <= 0)
                    continue;

                if (visited[nr][nc][nextHealth])
                    continue;

                visited[nr][nc][nextHealth] = true;
                queue.offer(new int[]{nr, nc, nextHealth});
            }
        }

        return false;
    }
}