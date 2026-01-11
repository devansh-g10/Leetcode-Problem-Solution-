class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0 ; i<nums.length ;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(target-sum) < Math.abs(target-closest)){
                    closest = sum;
                }
                if(sum<target){
                    left++;
                }
                else if (sum > target){
                    right--;
                }
                else return sum;
            }
        }
        return closest;
    }
}