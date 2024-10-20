import java.util.*;
import java.io.*;

public class ccc19s2 {
	static boolean prime(int N) {
		for(int i = 2; i < Math.sqrt(N)+1; i++) {
			if(N%i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++){
			int N = Integer.parseInt(br.readLine());
			for(int j = 2; j < N; j++) {
				if(prime(j) && prime(2*N-j)) {
					out.println(j + " " + (2*N-j));
					break;
				}
			}
		}
		out.flush();
	}

}
