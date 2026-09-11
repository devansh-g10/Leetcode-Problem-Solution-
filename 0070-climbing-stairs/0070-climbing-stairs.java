class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int x = 1;
        int y = 2;
        for(int i = 3 ; i<=n ; i++){
            int temp = x+y;
            x = y;
            y = temp;
        }
        return y;
    }
}