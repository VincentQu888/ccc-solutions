import java.util.*;
import java.io.*;

public class ccc14s2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, String> partners = new HashMap<>();
		String[] a = new String[N];
		String[] b = new String[N];
		boolean ans = true;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			a[i] = st.nextToken();
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			b[i] = st.nextToken();
		}
		for(int i = 0; i < N; i++) {
			partners.put(a[i], b[i]);
		}
		
		for(int i = 0; i < N; i++) {
			if(!a[i].equals(partners.get(partners.get(a[i]))) || a[i].equals(partners.get(a[i]))) {
				ans = false;
				break;
			}
		}
		
		if(ans == false) {
			out.println("bad");
		}else {
			out.println("good");
		}
		out.flush();
	}

}
