import java.util.*;
import java.io.*;

public class ccc20j3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		int[] y = new int[N];
		
		for(int i = 0; i < N; i++) {
			String coords = br.readLine();
			x[i] = Integer.parseInt(coords.substring(0, coords.indexOf(',')));
			y[i] = Integer.parseInt(coords.substring(coords.indexOf(',')+1));
		}
		Arrays.sort(x);
		Arrays.sort(y);
		
		int[] ans = new int[4];
		ans[0] = x[0]-1;
		ans[1] = y[0]-1;
		ans[2] = x[N-1]+1;
		ans[3] =  y[N-1]+1;
		
		out.println(ans[0] + "," + ans[1]);
		out.println(ans[2] + "," + ans[3]);
		out.flush();
	}

}
