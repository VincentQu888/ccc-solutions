import java.util.*;
import java.io.*;

public class ccc96s5 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int cases = Integer.parseInt(br.readLine());
		for(int test = 0; test < cases; test++) {
			int length = Integer.parseInt(br.readLine());
			int[] X = new int[length];
			int[] Y = new int[length];
			int l = 0;
			int r = 0;
			int ans = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < length; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < length; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			
			
			while(l < length && r < length) {
				if(r >= l && Y[r] >= X[l]) {
					if(r-l > ans) {
						ans = r-l;
					}
					r++;
				}else if(Y[r] < X[l]) {
					l++;
				}else {
					r++;
				}
			}
			
			out.println("The maximum distance is " + ans);
			
		}
		out.flush();
	}

}
