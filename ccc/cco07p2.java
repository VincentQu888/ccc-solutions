import java.util.*;
import java.io.*;

public class cco07p2 {
	
	static int[] shiftArr(int[] arr, int start) {
		int[] shifted = new int[6];
		for(int i = 0; i < 6; i++) {
			if(i+start >= 6) {
				shifted[i] = arr[i+start-6];
			}else {
				shifted[i] = arr[i+start];
			}
		}
		return shifted;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		HashSet<String> set = new HashSet<>();
		int[] arr = new int[6];
		int[] reversed = new int[6];
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				int input = Integer.parseInt(st.nextToken());
				arr[j] = input;
				reversed[5-j] = input;
			}
			
			String snowflake = Arrays.toString(arr);
			String reversedSnowflake = Arrays.toString(reversed);
			
			if(set.contains(snowflake) || set.contains(reversedSnowflake)) {
				out.println("Twin snowflakes found.");
				out.flush();
				System.exit(0);
			}else {
				set.add(snowflake);
				set.add(reversedSnowflake);
				for(int j = 1; j < 6; j++) {
					snowflake = Arrays.toString(shiftArr(arr, j));
					reversedSnowflake = Arrays.toString(shiftArr(reversed, j));
					
					if(set.contains(snowflake) || set.contains(reversedSnowflake)) {
						out.println("Twin snowflakes found.");
						out.flush();
						System.exit(0);
					}else {
						set.add(snowflake);
						set.add(reversedSnowflake);
					}
				}
			}
		}
		
		out.println("No two snowflakes are alike.");
		out.flush();
	}

}
