class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landDuration.length;
        int m = waterDuration.length;
        int a1 = Integer.MAX_VALUE;
        int a2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a1 = Math.min(a1, landStartTime[i] + landDuration[i]);
        }
        for (int i = 0; i < m; i++) {
            a2 = Math.min(a2, waterStartTime[i] + waterDuration[i]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(a2, landStartTime[i]) + landDuration[i]);
        }
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, Math.max(a1, waterStartTime[i]) + waterDuration[i]);
        }
        return ans;
    }
}