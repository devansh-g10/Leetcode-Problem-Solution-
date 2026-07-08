class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] val = new long[n + 1];
        long[] sum = new long[n + 1];
        int[] cnt = new int[n + 1];

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            val[i + 1] = val[i];
            sum[i + 1] = sum[i];
            cnt[i + 1] = cnt[i];

            if (d != 0) {
                val[i + 1] = (val[i] * 10 + d) % MOD;
                sum[i + 1] = sum[i] + d;
                cnt[i + 1]++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int len = cnt[r + 1] - cnt[l];

            long x = (
                val[r + 1] -
                (val[l] * pow10[len]) % MOD +
                MOD
            ) % MOD;

            long digitSum = sum[r + 1] - sum[l];

            ans[i] = (int) ((x * digitSum) % MOD);
        }

        return ans;
    }
}