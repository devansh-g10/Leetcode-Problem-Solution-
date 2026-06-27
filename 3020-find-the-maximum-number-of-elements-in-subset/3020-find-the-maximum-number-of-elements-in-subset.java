class Solution {
    public int maximumLength(int[] nums) {
         Map<Long, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge((long) num, 1, Integer::sum);
        }
 
        int ans = 1; // any single element is always a valid subset of size 1
 
        for (long num : freq.keySet()) {
            if (num == 1L) continue; // handled separately below
 
            long cur = num;
            int len = 0;
 
            // Walk the chain while the current value has at least 2 occurrences
            while (freq.containsKey(cur) && freq.get(cur) >= 2) {
                len++;
                cur = cur * cur; // safe: once cur > 1e9 it won't exist in freq, loop stops
            }
 
            // The next value can still be used once as the "peak" of the pattern
            if (freq.containsKey(cur)) {
                len++;
            }
 
            if (len > 0) {
                ans = Math.max(ans, 2 * len - 1);
            }
        }
 
        // Special case: x = 1 (all powers of 1 are 1)
        if (freq.containsKey(1L)) {
            int count = freq.get(1L);
            if (count % 2 == 0) count--; // pattern length must be odd
            ans = Math.max(ans, count);
        }
 
        return ans;
    }
}