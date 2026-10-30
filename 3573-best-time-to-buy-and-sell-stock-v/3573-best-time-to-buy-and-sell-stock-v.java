
class Solution {

    public long calculateFunc(int index, int state, int cap,
int[] prices, int n, long[][][] dp) {
        if (index == n) {
            if (state == 0) {
                return 0;
            }

            return Long.MIN_VALUE / 4;
        }
        if (cap == 0) {
            if (state == 0) {
                return 0;
            }

            return Long.MIN_VALUE / 4;
        }
        if (dp[index][state][cap] != Long.MIN_VALUE) {
            return dp[index][state][cap];
        }

        long profit;
        long skip;
        if (state == 0) {
            long buyStock = -(long) prices[index] + calculateFunc(index + 1, 1, cap, prices, n, dp);
            long shortSell = (long) prices[index] + calculateFunc(index + 1, 2, cap, prices, n, dp);
            skip = calculateFunc(index + 1, 0, cap, prices, n, dp);
            profit = Math.max(
                    skip,
                    Math.max(buyStock, shortSell)
            );
        }

        else if (state == 1) {
            long sellStock = (long) prices[index] + calculateFunc(index + 1, 0, cap - 1, prices, n, dp);

            skip = calculateFunc(index + 1, 1, cap, prices, n, dp);
            profit = Math.max(sellStock, skip);
        }

        else {
            long buyBack = -(long) prices[index] + calculateFunc(index + 1, 0, cap - 1, prices, n, dp);
            skip = calculateFunc(index + 1, 2, cap, prices, n, dp);

            profit = Math.max(buyBack, skip);
        }

        dp[index][state][cap] = profit;

        return profit;
    }

    public long maximumProfit(int[] prices, int k) {

    int n = prices.length;

    if (n == 0 || k == 0) {
        return 0L;
    }

    long[][][] dp = new long[n][3][k + 1];

    for (int i = 0; i < n; i++) {
        for (int state = 0; state < 3; state++) {
            for (int cap = 0; cap <= k; cap++) {
                dp[i][state][cap] = Long.MIN_VALUE;
            }
        }
    }
    return calculateFunc(0, 0, k, prices, n, dp);
}
}