import java.io.*;
import java.util.*;

public class ccc20j4 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String haystack = br.readLine();
		String needle = br.readLine();
		char[] shifts = new char[needle.length()];
		boolean YorN = false;
		int counter = 0;
		
		
		for(int i = 0; i < needle.length(); i++) {
			for(int j = i; j < needle.length()+i; j++) {
				if(j >= needle.length()) {
					shifts[counter] = needle.charAt(j-needle.length());
				}else {
					shifts[counter] = needle.charAt(j);	
				}
				counter++;
			}
			if(haystack.contains(new String(shifts))) {
				System.out.println("yes");
				YorN = true;
				break;
			}
			counter = 0;
		}
		
		if(!YorN) {
			System.out.println("no");
		}
		
	}

}
