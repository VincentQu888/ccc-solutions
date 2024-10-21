import java.util.*;
import java.io.*;

public class usaco20decs2 { //nvm

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[10][10];
        for(int i = 0; i < N; ++i) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken())+1, y = Integer.parseInt(st.nextToken())+1;
        	
        	grid[x][y]++;
        }
        
        for(int i = 1; i < 10; ++i) {
        	for(int j = 1; j < 10; ++j) {
        		grid[i][j] += grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
        	}
        	System.out.println(Arrays.toString(grid[i]));
        }
    }

}