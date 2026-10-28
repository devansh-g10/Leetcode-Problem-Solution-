class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,dp);
    }
    int solve(int idx , String s , int[] dp){
        if(idx == s.length()) return 1;
        if(s.charAt(idx) == '0') return 0;
        if(dp[idx] != -1){
            return dp[idx];
        }
        int ways = solve(idx+1 , s , dp);
        if(idx + 1 < s.length()){
            int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx+1) - '0');
            if(num >= 10 && num <= 26){
                ways += solve(idx+2,s,dp);
            }
        }
        return dp[idx] = ways;
    }
}