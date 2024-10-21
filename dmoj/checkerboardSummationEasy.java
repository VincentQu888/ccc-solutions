import java.util.*;
import java.io.*;

public class checkerboardSummationEasy {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        
        int[][] grid = new int[M][N];
        int[][] psa = new int[M+1][N+1];
        
        st = new StringTokenizer(br.readLine()); 
        for(int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()); r != 0 && c != 0 && x != 0;) {
        	if((r%2 == 0 && r%2 == 0) || (r%2 == 1 && r%2 == 1)) grid[r][c] = x;
        	else grid[r][c] = -x;
        	st = new StringTokenizer(br.readLine());
        }
        
        for(int i = 1; i < M; ++i) {
        	for(int j = 1; j < N; ++j) {
        		psa[i][j] = psa[i][j-1] + psa[i-1][j] - psa[i][j] + grid[i][j];
        	}
        }
        
        
        
    }

}