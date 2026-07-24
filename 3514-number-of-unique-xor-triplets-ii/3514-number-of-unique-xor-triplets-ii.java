import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        HashSet<Integer> pairXor = new HashSet<>();

        // Store XOR of every pair (i < j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }

        BitSet seen = new BitSet();

        // Triplets with all three indices same -> nums[i]
        for (int x : nums) {
            seen.set(x);
        }

        // Pair XOR ^ every element
        for (int p : pairXor) {
            for (int x : nums) {
                seen.set(p ^ x);
            }
        }

        return seen.cardinality();
    }
}