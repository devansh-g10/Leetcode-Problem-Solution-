class Solution {
    public int longestOnes(int[] nums, int k) {
        int s = 0;
        int e = 0;
        int t = 0;
        int max = 0;
        while(e < nums.length){
            if(nums[e] == 0){
                t++;
            }
            if(t > k){
                if(nums[s] == 0){
                    t--;
                }
                s++;
            }
            max = Math.max(e - s + 1, max);
            e++;
        }
        return max;
    }
}