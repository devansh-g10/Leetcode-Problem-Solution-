class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int offset = n + 2;
        Fenwick bit = new Fenwick(2 * n + 5);

        int ans = 0;

        // Insert prefix sum 0
        bit.add(prefix[0] + offset, 1);

        for (int i = 1; i <= n; i++) {
            // Previous prefix sums smaller than current prefix sum
            ans += bit.query(prefix[i] + offset - 1);
            bit.add(prefix[i] + offset, 1);
        }

        return ans;
    }

    class Fenwick {
        int[] tree;

        Fenwick(int size) {
            tree = new int[size + 1];
        }

        void add(int index, int value) {
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}