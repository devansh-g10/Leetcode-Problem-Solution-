class Solution {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for (int num : nums) {
            int digitSum = 0;
            int temp = num;
            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
            minSum = Math.min(minSum, digitSum);
        }
        return minSum;
    }
}