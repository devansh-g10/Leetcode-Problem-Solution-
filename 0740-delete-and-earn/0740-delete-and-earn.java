class Solution {
    public int deleteAndEarn(int[] nums) {
        // Using Top-Down Approach
        int max = 0;
        for(int x : nums){
            max = Math.max(max,x);
        }
        int[] freq = new int[max+1];
        for(int i = 0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int dp[] = new int[max + 1];
        Arrays.fill(dp,-1);
        return solve(0,freq,dp); 
    }
    public int solve(int idx , int[] freq , int[] dp){
        if(idx >= freq.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int skip = solve(idx+1,freq,dp);
        int take = solve(idx+2,freq,dp) + (idx * freq[idx]);
        return dp[idx] = Math.max(skip,take);
    }
}