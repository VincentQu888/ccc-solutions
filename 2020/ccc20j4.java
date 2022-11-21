import java.util.*;
import java.io.*;

public class ccc20j4 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String haystack = br.readLine();
		String needle = br.readLine();
		boolean ans = false;
		
		for(int i = 0; i < needle.length(); i++) {
			if(haystack.contains(needle.substring(i) + needle.substring(0, i))) {
				out.println("yes");
				ans = true;
				break;
			}
		}
		
		if(ans == false) {
			out.println("no");
		}
		out.flush();
	}

}
