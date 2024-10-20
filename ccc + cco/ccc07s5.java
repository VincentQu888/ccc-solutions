import java.util.*;
import java.io.*;

public class ccc07s5 {
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine());
        
        for(int cases = 0; cases < t; cases++) {
        	st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            
            int[] pins = new int[n];
            int[] sums = new int[n];
            int[][] dp = new int[k+1][n];
            for(int i = 0; i < n; i++) pins[i] = Integer.parseInt(br.readLine());
            
            for(int i = 0; i < n; i++) {
            	int sum = 0;
            	
            	for(int j = i; j < i+w && j < n; j++) {
            		sum += pins[j];
            	}
            	
            	sums[i] = sum;
            }
            
            
            for(int i = 1; i <= k; i++) {
            	for(int j = n-1; j >= 0; j--) {
            		if(j >= n-w) dp[i][j] = sums[j];
            		else dp[i][j] = Math.max(dp[i-1][j+w] + sums[j], dp[i][j+1]);
            	}
            }
            System.out.println(dp[k][0]);
        }
    }

}