class Solution {
    public boolean isPalindrome(int x) {
       int originalnum = x;
       int num = 0;
       if (x<0){
        return false;
       }
       while (x>0){
        int digit = x%10;
        num = num*10+digit;
        x/=10;
        }
        if (originalnum == num){
            return true;
        }
        else{
            return false;
        }
    }
}