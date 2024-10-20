package Solved;

import java.util.ArrayList;

public class Sort_Array_By_Parity {
	public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        int[] parity = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }
        
        for(int i = 0; i < even.size(); i++){
            parity[i] = even.get(i);
        }
        for(int i = even.size(); i < nums.length; i++){
            parity[i] = odd.get(i-even.size());
        }

        return parity;
    }
}
