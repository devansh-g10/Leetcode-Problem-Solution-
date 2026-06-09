class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long mn = Long.MAX_VALUE;
        long mx = Long.MIN_VALUE;

        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }

        return (mx - mn) * k;
    }
}