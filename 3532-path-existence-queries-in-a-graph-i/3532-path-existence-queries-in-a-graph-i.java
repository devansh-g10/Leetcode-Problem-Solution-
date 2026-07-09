class Solution {
    public boolean[] pathExistenceQueries(
            int n, int[] nums, int maxDiff, int[][] queries) {

        int[] component = new int[n];
        int id = 0;

        component[0] = id;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                id++;
            }

            component[i] = id;
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            ans[i] = component[u] == component[v];
        }

        return ans;
    }
}