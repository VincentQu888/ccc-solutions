package Solved;

import java.util.*;

public class Find_Lucky_Integer_in_an_Array {

	public int findLucky(int[] arr) {
		int ans = -1;
		
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i : arr) {
        	if(count.get(i) == null) count.put(i, 1);
        	else {
        		int temp = count.get(i);
        		count.put(i, temp+1);
        	}
        }
        
        for(int i : arr) {
        	if(count.get(i) == i && i > ans) {
        		ans = i;
        	}
        }
        return ans;
    }

}
