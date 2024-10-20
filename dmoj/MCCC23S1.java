import java.util.*;
import java.io.*;

public class MCCC23S1 {

	public static boolean canConstruct(String str, HashSet<String> fib, int start) {
		if(start == str.length()) return true;
		for(int i = 0; i < str.length()-start; i++) {
			for(int j = start; j <= str.length()-i; j++) {
				String substr = str.substring(start, j+i);
				if(fib.contains(substr)) {
					int newStart = j+i;
					if(canConstruct(str, fib, newStart)) return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		HashSet<String> fib = new HashSet<>();
		fib.add(Integer.toString(0));
		int l = 0;
		int r = 1;
		int temp;
		while(l+r < Math.pow(10, 5)) {
			fib.add(Integer.toString(l+r));
			temp = r;
			r = l+r;
			l = temp;
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			String n = br.readLine();
			if(n.length() == 1) out.println("NO");
			else if(canConstruct(n, fib, 0)) out.println("YES");
			else out.println("NO");
		}
		
		out.flush();
	}

}
