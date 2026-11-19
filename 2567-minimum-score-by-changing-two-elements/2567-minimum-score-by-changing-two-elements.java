class Solution {
    public int minimizeSum(int[] nums) {
        int s0 = Integer.MAX_VALUE, s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
        int l0 = 0, l1 = 0, l2 = 0;

        for (int x : nums) {
            if (x < s0) {
                s2 = s1;
                s1 = s0;
                s0 = x;
            } else if (x < s1) {
                s2 = s1;
                s1 = x;
            } else if (x < s2) {
                s2 = x;
            }

            if (x > l0) {
                l2 = l1;
                l1 = l0;
                l0 = x;
            } else if (x > l1) {
                l2 = l1;
                l1 = x;
            } else if (x > l2) {
                l2 = x;
            }
        }

        return Math.min(l0 - s2, Math.min(l2 - s0, l1 - s1));
    }
}