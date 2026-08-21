class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> arr = new HashMap<>();
        int s = 0; 
        int e = 0;
        int max = 0;
        int t = 0;
        while(e < fruits.length){
            arr.put(fruits[e], arr.getOrDefault(fruits[e], 0) + 1);
            while(arr.size() > 2){
                arr.put(fruits[s], arr.get(fruits[s]) - 1);
                if(arr.get(fruits[s]) ==  0){
                    arr.remove(fruits[s]);
                }
                s++;
            }
            max = Math.max(e - s + 1, max);
            e++;
        }
        return max;
    }
}