import java.io.*;
import java.util.*;

public class cyclicShifts {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String haystack = br.readLine();
		StringBuilder needle = new StringBuilder(br.readLine());
		HashSet<StringBuilder> set = new HashSet<>();
		boolean ans = false;
		
		for(int i = 0; i < haystack.length()-needle.length()+1; i++) {
			StringBuilder a = new StringBuilder(haystack.subSequence(i, needle.length()+i));
			set.add(a);
		}
		
		StringBuilder a = new StringBuilder(needle);
		for(int i = 0; i <= needle.length(); i++) {
			if(set.contains(a)) {
				ans = true;
				break;
			}
			a.append(a.charAt(0));
			a.deleteCharAt(0);

		}
		
		if(ans == true) {
			out.println("yes");
		}else {
			out.println("no");
		}
		out.println(set);
		out.println(set.contains(new StringBuilder(haystack.subSequence(3, needle.length()+3))));
		out.flush();
	}

}
