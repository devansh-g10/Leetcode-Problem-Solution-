class Solution {
    public long countCommas(long n) {
        if (n <= 999L) {
            return 0;
        } else if (n >= 1000L && n <= 999999L) {
            return n - 999L;
        } else if (n >= 1000000L && n <= 999999999L) {
            return (n - 999999L) * 2L + 999000L;
        } else if (n >= 1000000000L && n <= 999999999999L) {
            return (n - 999999999L) * 3L + (999000000L) * 2L + 999000L;
        } else if (n >= 1000000000000L && n <= 999999999999999L) {
            return (n - 999999999999L) * 4L + (999000000000L) * 3L + (999000000L) * 2L + 999000L;
        }
        return (n - 999999999999999L) * 5L + (999000000000000L) * 4L + (999000000000L) * 3L + (999000000L) * 2L
                + 999000L;
    }
}