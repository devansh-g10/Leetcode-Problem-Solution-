class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,n-1,dp);
        
    }
    public int solve(int[] nums , int k , int[] dp){
        if(k==0) return nums[k];
        if(k==1) return Math.max(nums[1],nums[0]);
        if(dp[k] != -1){
            return dp[k];

        }
        int x = solve(nums,k-1,dp);
        int y = nums[k] + solve(nums , k-2,dp);
        dp[k] = Math.max(x,y);
        return dp[k];
    }

}