import java.util.*;
import java.io.*;

public class bsspc22p4 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] line = new int[N];
		int[] psa = new int[N+1];
		int ignore = 0;
		int index = N-1;
		boolean bool = false;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
			psa[i+1] = line[i]+psa[i]; 
			
			if(line[i] > ignore && psa[i+1] - ignore <= T) {
				ignore = line[i];
			}
			if(psa[i+1] - ignore > T) {
				index = i;
			}
		}
		
		
		out.println(index);
		out.flush();
	}

}
