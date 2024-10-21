import java.util.*;
import java.io.*;

public class coci06c2p4 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		out.println(n*(n-1)*(n-2)*(n-3)/24);
		out.flush();
	}

}
