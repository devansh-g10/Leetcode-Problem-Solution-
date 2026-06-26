import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        long[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Long, Integer> map = new HashMap<>();
        int idx = 1;
        for (long x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        Fenwick bit = new Fenwick(idx + 2);

        long ans = 0;

        for (long x : prefix) {
            int id = map.get(x);
            ans += bit.query(id - 1);
            bit.update(id, 1);
        }

        return ans;
    }

    static class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 2];
        }

        void update(int i, int delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}