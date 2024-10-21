import java.util.*;
import java.io.*;

public class BalticOI03p5 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] lamps = new int[N];
		
		for(int i = 0; i < N; i++) {
			lamps[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(j < N-1) {
					if(lamps[j+1] == 1) {
						if(lamps[j] == 0) {
							lamps[j] = 1;
						}else {
							lamps[j] = 0;
						}
					}
				}else {
					if(lamps[0] == 1) {
						if(lamps[j] == 0) {
							lamps[j] = 1;
						}else {
							lamps[j] = 0;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			out.println(lamps[i]);
		}
		out.flush();
	}

}
