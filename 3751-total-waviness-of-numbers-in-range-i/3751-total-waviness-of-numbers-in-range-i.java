class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int num = num1; num <= num2; num++) {
            ans += waviness(num);
        }

        return ans;
    }

    private int waviness(int num) {
        String s = String.valueOf(num);

        if (s.length() < 3) return 0;

        int count = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            int left = s.charAt(i - 1) - '0';
            int cur = s.charAt(i) - '0';
            int right = s.charAt(i + 1) - '0';

            if ((cur > left && cur > right) ||
                (cur < left && cur < right)) {
                count++;
            }
        }

        return count;
    }
}