class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int i = 0;
        for(int num : nums){
            if((i < k) || (nums[i-k]!=num)){
                nums[i]=num;
                i++;
            }
        }
        return Arrays.copyOf(nums,i);
    }
}