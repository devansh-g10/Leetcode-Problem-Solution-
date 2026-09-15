class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i = 2;i<n;i++){
            int x = nums[i] + dp[i-2];
            int y = dp[i-1];
            dp[i] = Math.max(x,y);
        }
        return dp[n-1];
    }
}