import java.util.*;
import java.io.*;

public class ccc12s5 {
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] lab = new int[R][C];
		
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			lab[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = -1;
		}
		
		
		lab[0][0] = 1;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(lab[i][j] != -1) {
					try {
						if(lab[i][j-1] != -1) {
							lab[i][j] += lab[i][j-1];
						}
					}catch(ArrayIndexOutOfBoundsException aioobe){}
					try {
						if(lab[i-1][j] != -1) {
							lab[i][j] += lab[i-1][j];
						}
					}catch(ArrayIndexOutOfBoundsException aioobe){}
				}
			}
		}
		
		out.println(lab[R-1][C-1]);
		out.flush();
	}

}
