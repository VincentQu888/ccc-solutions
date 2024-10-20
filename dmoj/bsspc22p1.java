import java.util.*;
import java.io.*;

public class bsspc22p1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += Integer.parseInt(br.readLine());
			out.println(ans);
		}
		
		out.flush();
	}

}
