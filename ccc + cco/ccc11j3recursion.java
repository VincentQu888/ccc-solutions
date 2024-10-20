import java.util.*;
import java.io.*;

public class ccc11j3recursion {
	
	static int counter = 2;
	
	static void sumac(int t1, int t2) {
		if(t1-t2 >= 0) {
			counter++;
			sumac(t2, t1-t2);
		}
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t1 = Integer.parseInt(br.readLine());
		int t2 = Integer.parseInt(br.readLine());
		
		sumac(t1, t2);
		
		out.println(counter);
		out.flush();
	}

}
