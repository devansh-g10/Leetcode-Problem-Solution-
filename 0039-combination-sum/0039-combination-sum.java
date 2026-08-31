class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(candidates, 0, target, ans, result);
        return result;
    }
    static void solve(int[] candidates, int i, int target, List<Integer> arr, List<List<Integer>> arr1){
        if(target == 0){
            arr1.add(new ArrayList<>(arr));
            return;
        }
        if(i == candidates.length){
            return;
        }
        if(candidates[i] <= target){
            arr.add(candidates[i]);
            solve(candidates, i, target - candidates[i], arr, arr1);
            arr.remove(arr.size() - 1);
        }
            solve(candidates, i + 1, target, arr, arr1);
    }
}