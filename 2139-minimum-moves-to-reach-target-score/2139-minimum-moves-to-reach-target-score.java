class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;

        while (target > 1 && maxDoubles > 0) {
            if ((target & 1) == 1) {
                target--;
            } else {
                target >>= 1;
                maxDoubles--;
            }
            moves++;
        }

        return moves + (target - 1);
    }
}