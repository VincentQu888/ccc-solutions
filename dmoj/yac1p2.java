import java.util.*;
import java.io.*;

public class yac1p2 {
	
	static List<Integer>[] adj;
	static char[] node;
	static int[][] memo;

	public static int[] count(int cur) {
		if(memo[cur][0] != 0 || memo[cur][1] != 0 || memo[cur][2] != 0) return memo[cur];
		
		int[] ans = new int[3];
		for(int next : adj[cur]) {
			ans[0] += count(next)[0];
			ans[1] += count(next)[1];
			ans[2] += count(next)[2];
		}
		
		return ans;
	}
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        int N = Integer.parseInt(br.readLine());
        node = new char[N];
        memo = new int[N][3];
        
        String colour = br.readLine();
        for(int i = 0; i < N; i++) {
        	node[i] = colour.charAt(i);
        }
        
        
        for(int i = 0; i < N-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken())-1, v = Integer.parseInt(st.nextToken())-1;
        	
        	adj[u].add(v);
        	adj[v].add(u);
        }
        
        
        
    }

}