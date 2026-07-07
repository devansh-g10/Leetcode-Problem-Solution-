class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        int sum = 0;

        for (char c : String.valueOf(n).toCharArray()) {
            int d = c - '0';
            if (d != 0) {
                x = x * 10 + d;
                sum += d;
            }
        }

        return x * sum;
    }
}