import java.util.*;
import java.io.*;

public class dmopc22c2p1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
	
		int N = Integer.parseInt(br.readLine());
		boolean[] table = new boolean[N];
		int counter = 0;
		String[] ans = new String[N];
		
		table[0] = true;
		table[N-1] = true;
		for(int i = 1; i < N-1; i++) {
			if(table[i-1] == false && table[i+1] == false) {
				table[i+1] = true;
			}
		}
		for(int i = 0; i < N; i++) {
			if(table[i] == false) {
				ans[i] = "M";
				counter++;
			}else {
				ans[i] = "_";
			}
		}
			
		out.println(counter);
		for(int i = 0; i < N; i++) {
			out.print(ans[i]);
		}
		out.flush();
	}

}