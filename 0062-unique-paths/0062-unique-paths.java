class Solution {
    public int uniquePaths(int m, int n) {
        int totalN = m+n-2;
        int totalR = m-1;
        long res = 1;
        for(int i=1; i <= totalR; i++){
            res = res * (totalN - totalR + i) / i;
        }
        return (int) res;
        
    }
}