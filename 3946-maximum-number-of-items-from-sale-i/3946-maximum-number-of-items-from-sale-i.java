class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxF = 0, minP = Integer.MAX_VALUE;
        for (int[] it : items) {
            maxF = Math.max(maxF, it[0]);
            minP = Math.min(minP, it[1]);
        }
        int[] freq = new int[maxF + 1];
        for (int[] it : items) freq[it[0]]++;
        int[] mult = new int[maxF + 1];
        for (int d = 1; d <= maxF; d++) {
            for (int k = d; k <= maxF; k += d) mult[d] += freq[k];
        }
        int[] dp = new int[budget + 1];
        for (int[] it : items) {
            int val = mult[it[0]], p = it[1];
            for (int b = budget; b >= p; b--) {
                dp[b] = Math.max(dp[b], dp[b - p] + val);
            }
        }
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b] + (budget - b) / minP);
        }
        return ans;
    }
}