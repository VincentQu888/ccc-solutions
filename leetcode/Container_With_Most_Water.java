package Solved;

class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int ans = 0;
        
        while(l < r) {
        	if(Math.min(height[l], height[r])*(r-l) > ans) {
        		ans = Math.min(height[l], height[r])*(r-l);
        	}
        	if(height[l] < height[r]) {
        		l++;
        	}else {
        		r--;
        	}
        }
        
        return ans;
    }
}
