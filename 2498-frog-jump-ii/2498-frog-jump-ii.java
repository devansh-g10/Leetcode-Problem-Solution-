class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int ans = stones[1] - stones[0];
        for(int i = 2;i<n;i++){
            ans = Math.max(ans,stones[i] - stones[i-2]);
        }
        return ans;
    }
}