class Solution {
    public int uniquePaths(int m, int n) {
        int i = 0;
        int j = 0;
        int[][] dp = new int[m+1][n+1];
        for(int[] num : dp){
            Arrays.fill(num,-1);
        }
        return solve(m,n,0,0,dp);
    }
    public int solve(int m , int n , int i , int j , int[][] dp){
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(i==m || j == n){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        } 
        dp[i][j] = solve(m,n,i,j+1,dp) + solve(m,n,i+1,j,dp);
        return dp[i][j];
    }
}