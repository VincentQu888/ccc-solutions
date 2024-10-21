import java.util.*;
import java.io.*;

public class dpb {

	static int[] memo;
	static int[] cost;
	static int K;
	
	public static int jump(int stone) {
		if(memo[stone] != -1) return memo[stone];
		
		memo[stone] = Integer.MAX_VALUE;
		for(int i = 1; i <= K && i < stone; i++) memo[stone] = Math.min(memo[stone], Math.abs(cost[stone-i]-cost[stone]) + jump(stone-i));
		
		return memo[stone];
	}
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        memo = new int[N+1];
        cost = new int[N+1];
        Arrays.fill(memo, -1);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) cost[i] = Integer.parseInt(st.nextToken());
        memo[0] = 0;
        memo[1] = 0;
        memo[2] = Math.abs(cost[1]-cost[2]);
        
        out.println(jump(N));
        out.flush();
    }

}