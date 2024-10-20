import java.util.*;
import java.io.*;

public class ccc11s3 {
	
	static boolean magnify(int m, int a, int b) {
		int x = (int) (a/Math.pow(5, m-1));
		int y = (int) (b/Math.pow(5, m-1));
		
		if((x == 1 && y == 0) || (x == 2 && y == 0) || (x == 3 && y == 0) || (x == 2 && y == 1)) {
			return true;
		}else if((x == 1 && y == 1) || (x == 3 && y == 1) || (x == 2 && y == 2)) {
			return magnify(m - 1, a%(int) Math.pow(5, m - 1), b%(int) Math.pow(5, m - 1));
		}else {
			return false;
		}
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(magnify(m, x, y) == true) {
				out.println("crystal");
			}else {
				out.println("empty");
			}
		}
		
		out.flush();
	}

}