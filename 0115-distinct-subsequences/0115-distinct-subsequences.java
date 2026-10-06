class Solution {
    //Top-Down Approach 
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] nums : dp){
            Arrays.fill(nums,-1);
        }
        return solve(s,t,0,0,dp);
    }
    public int solve(String s , String t, int i , int j, int[][] dp){
        if(j>=t.length()){
            return 1;
        }
        if(i>=s.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            int skip = solve(s , t , i+1 , j, dp);
            int take = solve(s , t , i+1 , j+1 , dp);
            dp[i][j] = skip + take;
            return skip + take;
        }
        return solve(s,t,i+1,j , dp);
    }
}