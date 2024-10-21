import java.util.*;
import java.io.*;

public class dpm {

	static int[] children;
	static int[][] memo;
	
	public static int candies(int cur, int remaining) {
		cur--; remaining--;
		
		if(cur <= -1 || remaining <= 0) return 0;
		if(memo[cur][remaining] != -1) return memo[cur][remaining];

		int K =  Math.min(children[cur], remaining);
		for(int i = 0; i < K; i++) {
			memo[cur][remaining] += candies(cur, remaining+1-i);
		}
		
		return memo[cur][remaining];
	}
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        children = new int[N];
        memo = new int[N][K];
                                 
        for(int i = 0; i < N; i++) Arrays.fill(memo[i], -1);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) children[i] = Integer.parseInt(st.nextToken());
        

        out.println(candies(N, K));
        out.flush();
    }

}