package Solved;

class Solution {
    public int maxSubArray(int[] nums) {
        int pointer1 = nums[0];
        int pointer2 = 0;
        int ans = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(pointer1 < 0){
                pointer2 = nums[i];
                if(pointer2 > ans){
                    ans = pointer2;
                }
                pointer1 = pointer2;
            }else{
                pointer1 += nums[i];
                pointer2 = pointer1;
                if(pointer2 > ans){
                    ans = pointer2;
                }
            }
        }
        return ans;
    }
}