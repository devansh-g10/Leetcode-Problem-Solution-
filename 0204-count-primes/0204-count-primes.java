class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] Prime = new boolean[n];
        for (int i = 2; i < n; i++) {
            Prime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (Prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    Prime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (Prime[i]) {
                count++;
            }
        }

        return count;
    }
}