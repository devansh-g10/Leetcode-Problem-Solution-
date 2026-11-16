class Solution {
    public String digitSum(String s, int k) {
        int t=s.length();
        if(t<=k){
            return s;
        }
        StringBuilder ans=new StringBuilder();

        int sum=0;
      
        for(int i=0;i<t;i++){
            sum+=s.charAt(i)-'0';
            if((i+1)%k == 0){
                ans.append(sum);
                sum=0;     
            }          
        }
        if(t%k != 0){
                ans.append(sum);
            }
        return digitSum(String.valueOf(ans),k);
    }
}