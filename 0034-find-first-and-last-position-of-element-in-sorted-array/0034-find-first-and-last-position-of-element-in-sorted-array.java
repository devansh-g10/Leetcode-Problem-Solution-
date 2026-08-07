class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = firstPosition(nums,target);
        int e = LastPosition(nums,target);
        return new int[] {s,e};
    }

    public int firstPosition(int[] nums , int target){
        int left = 0;
        int right = nums.length - 1;
        int floor = -1;
        while(left<= right){
            int mid = left + (right - left)/2;

            if(nums[mid]==target){
                floor = mid;
                right = mid -1;
            }
            else if (nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid +1;
            }
        }
        return floor;
    }
    static int LastPosition(int[] nums , int target){
        int left = 0;
        int right = nums.length-1;
        int ceil = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                ceil = mid;
                left = mid +1;
            }
            else if(nums[mid]>target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ceil;
    }
}