class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        int size = 2 * m;

        // Base state for length = 2
        long[] state = new long[size];

        for (int v = 1; v <= m; v++) {
            state[v - 1] = v - 1;         // up[v]
            state[m + v - 1] = m - v;     // down[v]
        }

        if (n == 2) {
            long ans = 0;
            for (long x : state) ans = (ans + x) % MOD;
            return (int) ans;
        }

        long[][] trans = new long[size][size];

        // up'[v] = sum down[u], u < v
        for (int v = 1; v <= m; v++) {
            int row = v - 1;

            for (int u = 1; u < v; u++) {
                trans[row][m + u - 1] = 1;
            }
        }

        // down'[v] = sum up[u], u > v
        for (int v = 1; v <= m; v++) {
            int row = m + v - 1;

            for (int u = v + 1; u <= m; u++) {
                trans[row][u - 1] = 1;
            }
        }

        long[][] power = matrixPower(trans, n - 2);

        long[] result = multiply(power, state);

        long ans = 0;
        for (long x : result) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[][] matrixPower(long[][] base, long exp) {
        int n = base.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                long val = a[i][k];

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    c[i][j] = (c[i][j] + val * b[k][j]) % MOD;
                }
            }
        }

        return c;
    }

    private long[] multiply(long[][] mat, long[] vec) {
        int n = mat.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;

                cur = (cur + mat[i][j] * vec[j]) % MOD;
            }

            res[i] = cur;
        }

        return res;
    }
}