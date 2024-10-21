import java.io.*;
import java.util.*;

public class Deforestation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		int trees[] = new int[n+1];
		trees[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			trees[i] = Integer.parseInt(br.readLine());
			trees[i] += trees[i-1];
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			out.println(trees[end+1] - trees[start]);
		}
		out.flush();
	}

}