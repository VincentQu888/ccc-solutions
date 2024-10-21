import java.util.*;
import java.io.*;

public class dpn {
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
        long[] slimes = new long[N];
        long[][] memo = new long[N][N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	slimes[i] = Long.parseLong(st.nextToken());
        }
        
        
        for(int i = N-1; i >= 0; i--) {
        	for(int j = 0; j < N; j++) {
        		if(i == j) memo[i][j] = 0;
        		else {
        			memo[i][j] = Long.MAX_VALUE;
    				long sum = 0;
    				for(int l = i; l <= j; l++) {
    					sum += slimes[l];
    				}
    				
        			for(int k = i; k < j; k++) {  				
        				memo[i][j] = Math.min(memo[i][j], memo[i][k] + memo[k+1][j] + sum);
        			}
        		}
        	}
        }
        
        out.println(memo[0][N-1]);
        out.flush();
    }

}