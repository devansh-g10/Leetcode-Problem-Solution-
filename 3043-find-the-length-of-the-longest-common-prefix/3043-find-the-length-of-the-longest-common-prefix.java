class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> prefixes = new HashSet<>();

        // Store all prefixes from arr1
        for (int num : arr1) {
            String s = String.valueOf(num);

            for (int i = 1; i <= s.length(); i++) {
                prefixes.add(s.substring(0, i));
            }
        }
        int ans = 0;
        // Check prefixes from arr2
        for (int num : arr2) {
            String s = String.valueOf(num);

            for (int i = 1; i <= s.length(); i++) {
                String pref = s.substring(0, i);

                if (prefixes.contains(pref)) {
                    ans = Math.max(ans, i);
                }
            }
        }
        return ans;
    }
}