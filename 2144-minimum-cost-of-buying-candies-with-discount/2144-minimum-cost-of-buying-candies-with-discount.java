class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        int n = cost.length;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count++;
            if (count % 3 != 0) {
                total += cost[i];
            }
        }
        return total;
    }
}