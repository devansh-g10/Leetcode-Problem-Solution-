import java.util.*;

class Solution {

    static class Pair {
        long cnt;
        long sum;

        Pair(long cnt, long sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }

    private char[] digits;
    private Map<Long, Pair> memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 0) return 0;

        digits = Long.toString(n).toCharArray();
        memo = new HashMap<>();

        Pair res = dfs(0, 1, 0, 0, 0, 0);
        return res.sum;
    }

    private Pair dfs(int pos, int tight, int started,
                     int lenState, int last2, int last1) {

        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (tight == 0) {
            long key = encode(pos, started, lenState, last2, last1);
            Pair cached = memo.get(key);
            if (cached != null) return cached;
        }

        int limit = (tight == 1) ? digits[pos] - '0' : 9;

        long totalCnt = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                Pair child = dfs(pos + 1, ntight, 0, 0, 0, 0);

                totalCnt += child.cnt;
                totalSum += child.sum;
            } else {

                if (started == 0) {
                    Pair child = dfs(pos + 1, ntight, 1, 1, 0, d);

                    totalCnt += child.cnt;
                    totalSum += child.sum;
                }
                else if (lenState == 1) {
                    Pair child = dfs(pos + 1, ntight, 1, 2, last1, d);

                    totalCnt += child.cnt;
                    totalSum += child.sum;
                }
                else {
                    int contrib = 0;

                    if ((last1 > last2 && last1 > d) ||
                        (last1 < last2 && last1 < d)) {
                        contrib = 1;
                    }

                    Pair child =
                            dfs(pos + 1, ntight, 1, 2, last1, d);

                    totalCnt += child.cnt;
                    totalSum += child.sum + contrib * child.cnt;
                }
            }
        }

        Pair ans = new Pair(totalCnt, totalSum);

        if (tight == 0) {
            long key = encode(pos, started, lenState, last2, last1);
            memo.put(key, ans);
        }

        return ans;
    }

    private long encode(int pos, int started, int lenState,
                        int last2, int last1) {

        long key = pos;
        key = key * 2 + started;
        key = key * 3 + lenState;
        key = key * 11 + last2;
        key = key * 11 + last1;

        return key;
    }
}