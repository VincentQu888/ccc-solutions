package Solved;

class Climbing_Stairs {
	static int memo[];
	
	public static int dp(int step){
		if(memo[step] != 0) return memo[step];
		return memo[step] = dp(step-1)+dp(step-2);
	}
	
    public int climbStairs(int n) {
        memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        return dp(n);
    }
}