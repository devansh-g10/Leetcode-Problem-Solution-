class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
         int arr[] = new int[nums.length];
       int k = 0;
       for(int i=0;i<nums.length;i++){
        if(nums[i]<pivot){
            arr[k] = nums[i];
            k++;
        }
       }
       for(int i=0;i<nums.length;i++){
        if(nums[i]==pivot){
            arr[k]=nums[i];
            k++;
        }
       }
       for(int i=0;i<nums.length;i++){
        if(nums[i]>pivot){
            arr[k] = nums[i];
            k++;
        }
       }
       return arr;
    }
}