import java.util.*;
import java.io.*;

public class dmopc22c3p1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int grid = N*M;

		if(N%2 == 1 && M%2 == 1) out.println((Math.max(N, M)/2+1)*Math.min(N, M) + " " + (grid-(Math.max(N, M)/2+1)*Math.min(N, M)));
		else if(grid%2 == 0) out.println(grid/2 + " " + (grid-grid/2));
		else out.println(grid/2+1 + " " + (grid-(grid/2+1)));
		out.flush();
	}

}