import java.util.AbstractList;

class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return new AbstractList<List<Integer>>() {
            public List<Integer> get(int index) {
                init();
                return list.get(index);
            }
            public int size(){
                init();
                return list.size();
            }
            private void init() {
                if(list != null) return;
                Arrays.sort(nums);
                Set<List<Integer>> set = new HashSet<>();

                for(int one = 0; one < nums.length - 3; one++) {
                    if(one > 0 && nums[one] == nums[one - 1]) continue;
                    for(int two = one + 1; two < nums.length - 2; two++) {
                        if(two > one + 1 && nums[two] == nums[two - 1]) continue;
                        int three = two + 1;
                        int four = nums.length - 1;

                        while(three < four) {
                            long sum = (long)nums[one] + nums[two] + nums[three] + nums[four];
                            if(sum < target) three++;
                            else if(sum > target) four--;
                            else{
                                set.add(Arrays.asList(nums[one], nums[two], nums[three], nums[four]));
                                three++;
                                while(three < four && nums[three] == nums[three - 1]) three++;
                            }
                        }
                    }
                }
                list = new ArrayList<>(set);
            }
        };
    }
}