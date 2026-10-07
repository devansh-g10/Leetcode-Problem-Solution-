class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int[] nums : dp){
            Arrays.fill(nums,-1);
        }
        return solve(0,0,dungeon,dp);
    }
    public int solve(int i , int j , int[][] dungeon , int[][] dp){
        if(i>=dungeon.length || j>=dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==dungeon.length-1 && j==dungeon[0].length-1){
            return Math.max(1, (-1 * dungeon[i][j]) + 1);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = solve(i+1 , j , dungeon , dp);
        int right = solve(i , j+1 , dungeon , dp);
        int min = Math.min(down,right);
        int res = min - dungeon[i][j];
        return dp[i][j] = Math.max(1,res);

    }
}