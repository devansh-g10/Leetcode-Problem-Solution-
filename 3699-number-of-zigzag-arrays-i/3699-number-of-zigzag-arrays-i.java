class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2 initialization
        for (int y = 0; y < m; y++) {
            down[y] = y;              // count of x < y
            up[y] = m - 1 - y;        // count of x > y
        }

        // Build lengths 3..n
        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long[] prefixUp = new long[m];
            long[] prefixDown = new long[m];

            prefixUp[0] = up[0];
            prefixDown[0] = down[0];

            for (int i = 1; i < m; i++) {
                prefixUp[i] = (prefixUp[i - 1] + up[i]) % MOD;
                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
            }

            long totalUp = prefixUp[m - 1];
            long totalDown = prefixDown[m - 1];

            for (int y = 0; y < m; y++) {
                // newDown[y] = sum(up[x]) for x < y
                newDown[y] = (y == 0) ? 0 : prefixUp[y - 1];

                // newUp[y] = sum(down[x]) for x > y
                newUp[y] = (totalDown - prefixDown[y] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}