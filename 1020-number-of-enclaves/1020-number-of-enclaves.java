class Solution {
    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1)
                        && grid[i][j] == 1) {

                    dfs(grid, i, j);
                }
            }
        }

        // Ab jo 1 bache hain, wahi enclaves hain
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i - 1, j); // up
        dfs(grid, i + 1, j); // down
        dfs(grid, i, j - 1); // left
        dfs(grid, i, j + 1); // right
    }
}