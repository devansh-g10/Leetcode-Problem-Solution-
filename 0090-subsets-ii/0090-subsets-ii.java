class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums,0,ans,temp);
        return ans;
    }
    public void solve(int[] nums , int idx , List<List<Integer>> ans , List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int i = idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            solve(nums , i+1 , ans , temp);
            temp.remove(temp.size()-1);
        }
    }
}