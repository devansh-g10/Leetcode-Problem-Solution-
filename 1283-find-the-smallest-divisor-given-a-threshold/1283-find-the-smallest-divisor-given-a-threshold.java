class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int ans = Integer.MAX_VALUE;
        int start = 1;
        int end = max;
        while(start <= end){
            int mid = start + (end - start) / 2;
            long h = 0;
            for(int i = 0; i < nums.length; i++){
                h = h + (nums[i] + mid - 1) / mid;
            }
            if(h <= threshold){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
}