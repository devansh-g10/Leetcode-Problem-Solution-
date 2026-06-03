import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                        waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                        landStartTime, landDuration));

        return ans;
    }

    private int solve(int[] startA, int[] durA,
                      int[] startB, int[] durB) {

        int n = startB.length;

        int[][] rides = new int[n][2];

        for (int i = 0; i < n; i++) {
            rides[i][0] = startB[i];
            rides[i][1] = durB[i];
        }

        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        int[] suffixMin = new int[n];

        suffixMin[n - 1] =
                rides[n - 1][0] + rides[n - 1][1];

        for (int i = n - 2; i >= 0; i--) {

            suffixMin[i] = Math.min(
                    suffixMin[i + 1],
                    rides[i][0] + rides[i][1]
            );
        }

        int minDur = Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;

        int ptr = 0;

        int[][] sortedByEnd = new int[startA.length][2];

        for (int i = 0; i < startA.length; i++) {

            sortedByEnd[i][0] = startA[i] + durA[i];
            sortedByEnd[i][1] = i;
        }

        Arrays.sort(sortedByEnd, (a, b) -> a[0] - b[0]);

        for (int[] cur : sortedByEnd) {

            int endTime = cur[0];

            while (ptr < n && rides[ptr][0] <= endTime) {

                minDur = Math.min(minDur,
                        rides[ptr][1]);

                ptr++;
            }

            if (minDur != Integer.MAX_VALUE) {

                ans = Math.min(ans,
                        endTime + minDur);
            }

            if (ptr < n) {

                ans = Math.min(ans,
                        suffixMin[ptr]);
            }
        }

        return ans;
    }
}