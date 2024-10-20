import java.util.*;
import java.io.*;

public class ccc21s2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int rows[] = new int[M];
		int coloumns[] = new int[N];
		int counter = 0;
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("R")) {
				rows[Integer.parseInt(st.nextToken())-1]++;
			}else {
				coloumns[Integer.parseInt(st.nextToken())-1]++;
			}
		}
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if((rows[i]+coloumns[j])%2 == 1) {
					counter++;
				}
			}
		}
		System.out.println(counter);
	}

}
