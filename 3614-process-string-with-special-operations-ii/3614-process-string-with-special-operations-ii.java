class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        // Calculate final length
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (len > 0) len--;
            } else if (c == '#') {
                len *= 2;
            } else if (c == '%') {
                // length unchanged
            } else {
                len++;
            }
        }

        if (k >= len) return '.';

        // Reverse simulation
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') {
                len++;
            } 
            else if (c == '#') {
                len /= 2;
                if (k >= len) {
                    k -= len;
                }
            } 
            else if (c == '%') {
                k = len - 1 - k;
            } 
            else {
                len--;
                if (k == len) {
                    return c;
                }
            }
        }

        return '.';
    }
}