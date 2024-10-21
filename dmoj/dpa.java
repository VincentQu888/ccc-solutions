import java.util.*;
import java.io.*;

public class dpa {

	static int[] memo;
	static int[] cost;
	
	public static int jump(int stone) {
		if(memo[stone] != -1) return memo[stone];
		return memo[stone] = Math.min(Math.abs(cost[stone-1]-cost[stone]) + jump(stone-1), Math.abs(cost[stone-2]-cost[stone]) + jump(stone-2));
	}
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
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


/* tabulation solution
import java.util.*;
import java.io.*;

public class dpa {

	static int[] memo;
	static int[] cost;
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        cost = new int[N+1];
        Arrays.fill(memo, -1);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) cost[i] = Integer.parseInt(st.nextToken());
        memo[0] = 0;
        memo[1] = 0;
        memo[2] = Math.abs(cost[1]-cost[2]);
        
        for(int i = 3; i <= N; i++) {
    		int stone1 = Math.abs(cost[i]-cost[i-1])+memo[i-1];
    		int stone2 = Math.abs(cost[i]-cost[i-2])+memo[i-2];
    		
    		memo[i] = Math.min(stone1, stone2);
        }
        out.println(memo[N]);
        out.flush();
    }

}
*/