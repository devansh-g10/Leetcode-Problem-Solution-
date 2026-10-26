class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] q = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int front = 0, rear = 0;
                long sum = 0;
                q[rear++] = i * n + j;
                sum += grid[i][j];
                grid[i][j] = 0;
                while (front < rear) {
                    int pos = q[front++];
                    int x = pos / n;
                    int y = pos % n;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0) {
                            sum += grid[nx][ny];
                            q[rear++] = nx * n + ny;
                            grid[nx][ny] = 0;
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}