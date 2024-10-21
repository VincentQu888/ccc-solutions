import java.util.*;
import java.io.*;

public class aac3p2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		boolean possible = false;
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int potato[] = new int[D];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < D; i++) {
			potato[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(potato);
		
		for(int i = 0; i < D; i++) {
			if(potato[i] != 0) {
				possible = true;
			}
		}
		if(possible == false) {
			out.println(-1);
		}else if(potato[0] !=0) {
			for(int i = 0; i < K-1; i++) {
				out.print(potato[0]);
			}
			out.print(potato[0] + "\n");
		}else {
			if(K == 1) {
				out.println(potato[1]);
			}else {
				out.print(potato[1]);
				for(int i = 0; i < K-2; i++) {
					out.print(potato[0]);
				}
				out.print(potato[1] + "\n");
			}
		}
		
		out.flush();
	}
}