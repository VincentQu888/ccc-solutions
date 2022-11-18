import java.util.*;
import java.io.*;

public class ccc11s1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(br.readLine());
		int t = 0;
		int s = 0;
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			char[] charText = line.toCharArray();
			for(int j = 0; j < charText.length; j++) {
				if(charText[j] == 't' || charText[j] == 'T') {
					t++;
				}
				if(charText[j] == 's' || charText[j] == 'S') {
					s++;
				}
			}
		}
		
		if(t > s) {
			out.println("English");
		}else {
			out.println("French");
		}
		out.flush();
	}

}
