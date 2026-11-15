class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int sum = 0;
        long prefOdds = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefOdds += sum % 2;
        }
        prefOdds += (arr.length - prefOdds) * prefOdds;
        return (int) (prefOdds % 1000000007);
    }
}

