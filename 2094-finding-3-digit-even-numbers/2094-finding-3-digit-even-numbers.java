class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i = 0 ; i<n;i++){
            for(int j = 0; j<n;j++){
                for(int k = 0;k<n;k++){
                    if(i==j || j==k || i==k){
                        continue;
                    }
                    int num = (digits[i]*100) + (digits[j]*10) + (digits[k]*1);
                    if(num>=100 && num%2==0){
                        set.add(num);
                    }
                }
            }
        }
        // Set ki sabhi values Array list ke andar store ho jayegi kyuki set ko sort karna 
        //complicated ho jata hai but list ko sort kar skte hai isliye humne set ki values 
        // List mai store kra li hai
        List<Integer> resultList = new ArrayList<>(set);
        Collections.sort(resultList);
        int m = resultList.size();
        // humko return array mai karna hai to list ke sabhi elements array mai daal denge
        int[] result = new int[m];
        for(int i = 0;i<m;i++){
            result[i] = resultList.get(i);
        }
        return result;
    }
}