class Solution {
    private int[][] grid;
    private int m, n;

    private boolean closed(int i, int j) { 
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (grid[i][j] == 1) return true;  
        grid[i][j] = 1;  
        return closed(i + 1, j) & closed(i - 1, j) & closed(i, j + 1) & closed(i, j - 1);
    }

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0 && closed(i, j)) count++;
        return count;
    }
}