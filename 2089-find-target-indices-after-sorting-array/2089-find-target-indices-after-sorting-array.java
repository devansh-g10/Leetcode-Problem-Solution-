class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int LessThanTargetCount = 0;
        int TargetCount = 0;
        for(int num : nums){
            if(num < target){
                LessThanTargetCount++;
            }
            else if(num == target){
                TargetCount++;
            }
        }
    List<Integer> ans = new ArrayList<>();
    for(int i = 0; i<TargetCount ; i++){
        ans.add(LessThanTargetCount + i);
    }
    return ans;
    }
}