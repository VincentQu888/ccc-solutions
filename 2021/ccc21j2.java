import java.util.*;
import java.io.*;

public class ccc21j2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		String ans = "a";
		
		for(int i = 0; i < N; i++) {
			String tempString = br.readLine();
			int tempInt = Integer.parseInt(br.readLine());
			if(tempInt > max) {
				max = tempInt;
				ans = tempString;
			}
		}
		System.out.println(ans);
	}

}
