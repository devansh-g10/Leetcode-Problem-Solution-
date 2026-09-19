class Solution {
    private int m, n;
    private int[][] dp;

    private int solve(int[][] obstacleGrid, int i, int j) {
        if (i >= m || j >= n || obstacleGrid[i][j] == 1)
            return 0;

        if (i == m - 1 && j == n - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = solve(obstacleGrid, i + 1, j) + solve(obstacleGrid, i, j + 1);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(obstacleGrid, 0, 0);
    }
}