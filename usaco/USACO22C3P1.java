import java.util.*;
import java.io.*;

public class USACO22C3P1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] cows = new int[N];
		int max = 0;
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cows);
		
		for(int i = 0; i < N; i++) {
			if(cows[i]*N - cows[i]*i > max) {
				max = cows[i]*N - cows[i]*i;
				ans = cows[i];
			}
		}
		
		out.println(max + " " + ans);
		out.flush();
	}

}
