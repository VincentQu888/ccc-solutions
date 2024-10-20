import java.io.*;
import java.util.*;

public class ccc23s1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int C = Integer.parseInt(br.readLine());
		int[] row1 = new int[C];
		int[] row2 = new int[C];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			row1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			row2[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0 ; i < C-1; i++) {
			if(row1[i] == 1) ans += 3;
			if(row2[i] == 1) ans += 3;
			
			if(row1[i+1] == 1 && row1[i] == 1) ans -= 2;
			if(row2[i+1] == 1 && row2[i] == 1) ans -= 2;
			
			if(i%2 == 0 && row1[i] == 1 && row2[i] == 1) {
				ans -= 2;
			}
		}
		
		if(row1[C-1] == 1) ans += 3;
		if(row2[C-1] == 1) ans += 3;
		
		if((C-1)%2 == 0 && row1[C-1] == 1 && row2[C-1] == 1) {
			ans -= 2;
		}
		
		
		out.println(ans);
		out.flush();
	}

}