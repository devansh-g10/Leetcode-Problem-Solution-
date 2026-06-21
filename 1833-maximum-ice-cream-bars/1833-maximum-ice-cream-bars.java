class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int c = 0;
        int check = 0;
        Arrays.sort(costs);
        for(int i = 0;i<costs.length;i++){
            check = check + costs[i];
            if(coins>=check){
                c++;
            }else{
                return c;
            }
        }
        return c;
    }
}