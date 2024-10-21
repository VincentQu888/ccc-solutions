import java.util.*;
import java.io.*;

public class dmopc21c7p1 {
	
	public static int calculate(int i, int j, int[][] grid) {
		int bottomr;
		
		if(grid[i+1][j] <= grid[i][j+1]) {
			if(grid[i+1][j] == 0) bottomr = grid[i][j+1];
			else bottomr = grid[i+1][j];
		}
		else {
			if(grid[i][j+1] == 0) bottomr = grid[i+1][j];
			else bottomr = grid[i][j+1];
		}
		if(bottomr == 0) bottomr = Integer.MAX_VALUE;
		
		return bottomr;
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) grid[i][j] = Integer.parseInt(st.nextToken());
        }
        
        
        if(N == 1) {
        	for(int i = 0 ; i < M-1; i++) {
        		if(grid[0][i] == 0) {
        			if(i == 0 && 1 < grid[0][i+1]) grid[0][0]++;
        			else if(grid[0][i-1] < grid[0][i+1]) {
        				grid[0][i] = grid[0][i-1]++;
        			}
        		}
        	}
        	if(grid[0][M-1] == 0) grid[0][M-1] = grid[0][M-2]++;
        }
        
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) out.print(grid[i][j] + " ");
    		out.println();
    	}
        out.flush();
    }

}