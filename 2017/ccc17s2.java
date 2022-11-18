import java.util.*;
import java.io.*;

public class ccc17s2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(br.readLine());
		int[] measurements = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			measurements[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(measurements);
		int start = N/2;
		
		if(N%2 == 1) {
			out.print(measurements[start] + " ");
			for(int i = 0; i < N/2; i++) {
				out.print(measurements[start+i+1] + " ");
				out.print(measurements[start-i-1] + " ");
			}
		}else {
			for(int i = 0; i < N/2; i++) {
				out.print(measurements[start-i-1] + " ");
				out.print(measurements[start+i] + " ");
			}
		}
		
	
		out.flush();
	}

}