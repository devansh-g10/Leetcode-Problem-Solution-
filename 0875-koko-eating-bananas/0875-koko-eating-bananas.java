class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        int ans = Integer.MAX_VALUE;
        int start = 1;
        int end = max;
        while(start <= end){
            int mid = start + (end - start) / 2;
            long hours = 0;
            for(int i = 0; i < piles.length; i++){
                hours = hours + (piles[i] + mid - 1) / mid;
            }
            if(hours <= h){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
}