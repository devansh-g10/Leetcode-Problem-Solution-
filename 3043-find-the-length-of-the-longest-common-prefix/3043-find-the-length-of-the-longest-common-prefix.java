import java.util.*;

class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        // Store all prefixes of arr1
        for (int num : arr1) {

            while (num > 0) {
                set.add(num);
                num /= 10;
            }
        }

        int ans = 0;

        // Check prefixes in arr2
        for (int num : arr2) {

            while (num > 0) {

                if (set.contains(num)) {

                    int len = digits(num);

                    if (len > ans) {
                        ans = len;
                    }

                    break;
                }

                num /= 10;
            }
        }

        return ans;
    }

    private int digits(int num) {

        int count = 0;

        while (num > 0) {
            count++;
            num /= 10;
        }

        return count;
    }
}