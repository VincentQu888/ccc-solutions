package Solved;

class Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
        boolean solved = false;
        int counter = 0;
        int index = nums.length/2;
        int ceiling = nums.length;
        int floor = 0;
        while((int)(Math.log(nums.length) / Math.log(2)) != counter){
            if(nums[index] == target){
                return index;
            }else if(nums[index] > target){
                ceiling = index;
                index = (index + floor)/2;
            }else{
                floor = index;
                index = (index + ceiling)/2;
            }
            counter++;
        }
        if(target > nums[nums.length-1]){
            return nums.length;
        }else if(target < nums[0]){
            return 0;
        }
        else if(nums[index] > target){
            return index;
        }else{
            return index+1;
        }
    }
}