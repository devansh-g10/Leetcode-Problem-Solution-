class Solution {
    private void targetSum(int[] nums, int index, int[] count, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) count[0]++;
            return;
        }
        targetSum(nums, index + 1, count, sum + nums[index], target);
        targetSum(nums, index + 1, count, sum - nums[index], target);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int[] count = new int[1];
        targetSum(nums, 0, count, 0, target);
        return count[0];
    }
}