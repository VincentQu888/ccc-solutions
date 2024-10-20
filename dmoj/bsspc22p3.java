import java.util.*;
import java.io.*;

public class bsspc22p3 {
	
	static int ans = 0;
	
	static void next(boolean[][] seats, int x, int y) {
		int counter = 0;
		
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				try {
					if(seats[i][j] == true) {
						counter++;
					}
				}catch(ArrayIndexOutOfBoundsException aioobe) {}
			}
		}
		
		if(counter >= 3) {
			ans++;
		}
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[][] seats = new boolean[N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			seats[x][y] = true;
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(seats[i][j] == false) {
					next(seats, i, j);
				}
			}
		}
		
		out.println(ans);
		out.flush();
	}

}
