class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums,result,new ArrayList<>(),visited);
        return result;
    }
    public void backtrack(int[] nums , List<List<Integer>> result , List<Integer> ans , boolean[] visited){
        if(ans.size() == nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(visited[i]){
                continue;
            }
            ans.add(nums[i]);
            visited[i] = true;

            backtrack(nums , result , ans , visited);

            ans.remove(ans.size()-1);
            visited[i] = false;
        }
    }
}