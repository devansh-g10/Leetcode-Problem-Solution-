class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        int k = 1;
        for(char ch: s.toCharArray()){
            sum = sum + k*('z'-ch+1);
            k++;
        }
        return sum;
    }
}