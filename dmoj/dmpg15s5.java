import java.util.*;
import java.io.*;

public class dmpg15s5 {
	
	static short[][] grid;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        grid = new short[N+2][N+2];
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken())+1;
        	int y = Integer.parseInt(st.nextToken())+1;
        	int w = Integer.parseInt(st.nextToken());
        	int h = Integer.parseInt(st.nextToken());
        	
        	int x2 = x+w-1;
        	int y2 = y+h-1;
        	grid[x][y]++;
        	grid[x][y2+1]--;
        	grid[x2+1][y]--;
        	grid[x2+1][y2+1]++;
        }
        
        
        long ans = 0;
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		grid[i][j] += grid[i][j-1] + grid[i-1][j] - grid[i-1][j-1];
        		if(grid[i][j]%2 == 1) ans++;
        	}
        }

        System.out.println(ans);
    }

}