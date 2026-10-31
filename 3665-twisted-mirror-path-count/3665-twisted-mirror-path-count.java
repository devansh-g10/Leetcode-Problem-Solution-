class Solution {
    public int uniquePaths(int[][] grid) {
        final int mod = 1_000_000_007;
        int[] down = new int[grid[0].length];
        down[0] = 1;
        for (int[] row : grid) {
            int right = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    int t = right;
                    right = down[j];
                    down[j] = t;
                } else { 
                    right = down[j] = (right + down[j]) % mod;
                }
            }
        }
        return down[down.length - 1];
    }
}