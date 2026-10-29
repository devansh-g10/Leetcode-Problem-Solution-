import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0, memo);
    }
    
    private int helper(int[] nums, int idx, int[] memo) {
        // Agar hum last index ya usse aage pahunch gaye, toh 0 jumps chahiye
        if (idx >= nums.length - 1) {
            return 0;
        }
        
        // Agar pehle se calculated hai, toh wahi return kar do
        if (memo[idx] != -1) {
            return memo[idx];
        }
        
        int minJumps = 1000000; // Infinity ki tarah bada value
        int maxReach = Math.min(idx + nums[idx], nums.length - 1);
        
        // Current index se jitne distance tak jump kar sakte hain, sabhi ko try karo
        for (int nextIdx = idx + 1; nextIdx <= maxReach; nextIdx++) {
            int jumps = 1 + helper(nums, nextIdx, memo);
            minJumps = Math.min(minJumps, jumps);
        }
        
        return memo[idx] = minJumps;
    }
}