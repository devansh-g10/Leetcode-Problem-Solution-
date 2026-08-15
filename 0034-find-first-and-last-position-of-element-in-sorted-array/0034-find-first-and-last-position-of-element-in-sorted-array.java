class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = firstPosition(nums, target);
        int e = lastPosition(nums, target);

        return new int[] {s, e};
    }

    public int firstPosition(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }

    public int lastPosition(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }
}