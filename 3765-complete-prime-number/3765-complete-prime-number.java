class Solution {
    private boolean check(int n){
        if(n==0 || n==1) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public boolean completePrime(int num) {
        for (int i = num; i > 0; i /= 10) {
            if (!check(i)) return false;
        }
        for (long w = 10; w <= num; w *= 10) {
            if (!check((int)(num % w))) {
                return false;
            }
        }
        return true;
    }
}