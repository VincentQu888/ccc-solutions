import java.util.*;
import java.io.*;

public class ccc21j4 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		char[] shelf = br.readLine().toCharArray();
		int largeLength = 0;
		int mediumLength = 0;
		int largeInMedium = 0;
		int mediumInLarge = 0;
		int swaps = 0;
		
		
		for(int i = 0; i < shelf.length; i++) {
			if(shelf[i] == 'L') {
				largeLength++;
			}
			if(shelf[i] == 'M') {
				mediumLength++;
			}
		}
		
		for(int i = 0; i < largeLength; i++) {
			if(shelf[i] == 'M') {
				mediumInLarge++;
			}
			if(shelf[i] != 'L') {
				swaps++;
			}
		}
		
		for(int i = largeLength; i < largeLength+mediumLength; i++) {
			if(shelf[i] == 'L') {
				largeInMedium++;
			}
			if(shelf[i] != 'M') {
				swaps++;
			}
		}
		
		out.println(swaps-Math.min(mediumInLarge, largeInMedium));
		out.flush();
	}

}