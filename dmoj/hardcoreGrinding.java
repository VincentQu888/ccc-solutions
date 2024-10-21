import java.util.*;
import java.io.*;

public class hardcoreGrinding {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] tasks = new int[10000001];
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tasks[a]++;
			tasks[b]--;
		}
		
		for(int i = 0; i < 10000000; i++) {
			tasks[i+1] += tasks[i];
			if(tasks[i] > ans) {
				ans = tasks[i];
			}
		}
		
		out.println(ans);
		out.flush();
		
	}

}
