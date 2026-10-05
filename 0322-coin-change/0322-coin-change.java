class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        int ans = solve(coins,amount,dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int solve(int[] coins , int amount , int[] dp){
        if(amount==0) return 0;
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(dp[amount] != -1){
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<coins.length;i++){
            int ans = solve(coins,amount-coins[i],dp);
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(min, ans + 1);
            }
        }
        return dp[amount] = min;
    }
}