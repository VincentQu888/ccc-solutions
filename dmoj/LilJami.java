import java.util.*;
import java.io.*;

public class LilJami {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] psa = new int[N+1];
		
		psa[0] = 0;
		for(int i = 0; i < K; i++) {
			psa[Integer.parseInt(br.readLine())+1]++;
		}
		
		for(int i = 1; i <= N; i++) {
			psa[i] += psa[i-1];
		}
		
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			out.println(0-psa[Integer.parseInt(st.nextToken())] + psa[Integer.parseInt(st.nextToken())+1]);
		}
		out.flush();
	}

}
