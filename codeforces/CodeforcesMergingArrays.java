import java.util.*;
import java.io.*;

public class CodeforcesMergingArrays {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int pointer1 = 0;
		int pointer2 = 0;
		boolean loop = true;
		
		int[] Narr = new int[N];
		int[] Marr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			Narr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			Marr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(loop) {
			if(pointer1 >= N) {
				for(int i = pointer2; i < M; i++) {
					out.print(Marr[i] + " ");
				}
				break;
			}
			if(pointer2 >= M) {
				for(int i = pointer1; i < N; i++) {
					out.print(Narr[i] + " ");
				}
				break;
			}
			if(Narr[pointer1] > Marr[pointer2]) {
				out.print(Marr[pointer2] + " ");
				pointer2++;
			}else {
				out.print(Narr[pointer1] + " ");
				pointer1++;
			}
		}
		out.flush();
	}

}
