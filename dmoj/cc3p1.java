import java.util.*;
import java.io.*;

public class cc3p1 {
	
	static char[][] floor;
	
	public static void block(int i, int j) {
		try { if(floor[i+1][j] != 'W') floor[i+1][j] = 'C'; }catch (ArrayIndexOutOfBoundsException aioobe) {}
		try { if(floor[i-1][j] != 'W') floor[i-1][j] = 'C'; }catch (ArrayIndexOutOfBoundsException aioobe) {}
		try { if(floor[i][j+1] != 'W') floor[i][j+1] = 'C'; }catch (ArrayIndexOutOfBoundsException aioobe) {}
		try { if(floor[i][j-1] != 'W') floor[i][j-1] = 'C'; }catch (ArrayIndexOutOfBoundsException aioobe) {}
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        floor = new char[N][M];
        
        for(int i = 0; i < N; i++) {
        	String row = br.readLine();
        	
        	for(int j = 0; j < M; j++) {
        		char cur = row.charAt(j);
        		
        		if(floor[i][j] != 'C' || cur == 'W') floor[i][j] = cur;
        		if(cur == 'W') block(i, j);
        	}
        	
        }
        
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) out.print(floor[i][j]);
        	out.println();
        }
        out.flush();
    }

}