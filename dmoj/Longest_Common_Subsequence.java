import java.util.*;
import java.io.*;

public class Longest_Common_Subsequence {
	
	static int[][] memo;
	static String first;
	static String second;
	
	public static int lcs(int i, int j) {
		if(memo[i][j] != -1) return memo[i][j];
		if(i == 0 || j == 0) return memo[i][j] = 0;
		
		if(first.charAt(i-1) == second.charAt(j-1)) return memo[i][j] = lcs(i-1, j-1)+1;
		else return memo[i][j] = Math.max(lcs(i-1, j), lcs(i, j-1));
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        first = br.readLine();
        second = br.readLine();
        
        int N = first.length(), M = second.length();
        
        memo = new int[N+1][M+1];
        for(int i = 0; i <= N; i++) {
        	for(int j = 0; j <= M; j++) memo[i][j] = -1;
        }
        
        lcs(N, M);
        
        StringBuilder sb = new StringBuilder();
        int i = N, j = M;
        while (i > 0 && j > 0) {
            if (first.charAt(i-1) == second.charAt(j-1)) {
                sb.append(first.charAt(i-1));
                i--;
                j--;
            } else if (memo[i-1][j] >= memo[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        out.println(sb.reverse());
        out.flush();
    }

}