import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] sorted = new int[n];
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = nums[order[i]];
            pos[order[i]] = i;
        }

        // next[i] = farthest position reachable from i in one edge
        int[] next = new int[n];

        int r = 0;

        for (int i = 0; i < n; i++) {

            if (r < i) {
                r = i;
            }

            while (r + 1 < n &&
                   sorted[r + 1] - sorted[i] <= maxDiff) {
                r++;
            }

            next[i] = r;
        }

        // Binary Lifting
        int LOG = 1;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        int[][] jump = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            jump[0][i] = next[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int u = queries[qi][0];
            int v = queries[qi][1];

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            int left = pos[u];
            int right = pos[v];

            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }

            int cur = left;
            int steps = 0;

            // Take maximum jumps while still remaining before target
            for (int k = LOG - 1; k >= 0; k--) {

                if (jump[k][cur] < right &&
                    jump[k][cur] != cur) {

                    cur = jump[k][cur];
                    steps += (1 << k);
                }
            }

            // One final jump to target
            if (next[cur] >= right) {
                ans[qi] = steps + 1;
            } else {
                ans[qi] = -1;
            }
        }

        return ans;
    }
}