package Solved;

class Minimum_Operations_to_Make_the_Array_Increasing {
    public int minOperations(int[] nums) {
        int counter = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i+1] - nums[i] <= 0){
                counter += Math.abs(nums[i+1]-nums[i])+1;
                nums[i+1] += Math.abs(nums[i+1]-nums[i])+1;
            }
        }
        return counter;
    }
}