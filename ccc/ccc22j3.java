import java.util.*;
import java.io.*;

public class ccc22j3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String instructions = br.readLine() + 'a';
		int floor = 0;
		int ceil = 0;
		
		
		for(int i = 0; i < instructions.length(); i++) {
			if(instructions.charAt(i) == '+') {
				ceil = i;
				while(Character.isDigit(instructions.charAt(ceil+1)) && ceil+1 < instructions.length()) {
					ceil++;
				}
				
				System.out.println(instructions.substring(floor, i) + " tighten " + instructions.substring(i+1, ceil+1));
				floor = ceil+1;
				
			}else if(instructions.charAt(i) == '-') {
				ceil = i;
				while(Character.isDigit(instructions.charAt(ceil+1)) && ceil+1 < instructions.length()) {
					ceil++;
				}
				
				System.out.println(instructions.substring(floor, i) + " loosen " + instructions.substring(i+1, ceil+1));
				floor = ceil+1;
			}
		}
		
	}

}
