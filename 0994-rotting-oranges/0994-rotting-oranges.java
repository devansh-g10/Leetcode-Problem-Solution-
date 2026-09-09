class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> q = new ArrayDeque<>();
        int counter = 0;
        int fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    q.add(i * cols + j);
                }
            }
        }

        // BFS
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int current = q.poll();
                int row = current / cols;
                int col = current % cols;

                // Up
                if (row > 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    fresh--;
                    q.add((row - 1) * cols + col);
                }

                // Down
                if (row < rows - 1 && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    fresh--;
                    q.add((row + 1) * cols + col);
                }

                // Left
                if (col > 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    fresh--;
                    q.add(row * cols + (col - 1));
                }

                // Right
                if (col < cols - 1 && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    fresh--;
                    q.add(row * cols + (col + 1));
                }
            }

            counter++;
        }

        // If fresh oranges are still present
        if (fresh > 0) {
            return -1;
        }

        return counter;
    }
}