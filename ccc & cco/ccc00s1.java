import java.util.*;
import java.io.*;

public class ccc00s1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int quarters = Integer.parseInt(br.readLine());
		int machine1 = 36-Integer.parseInt(br.readLine());
		int machine2 = 101-Integer.parseInt(br.readLine());
		int machine3 = 11-Integer.parseInt(br.readLine());
		int ans = 0;
		
		while(quarters > 0) {
			if(machine1 - 1 == 0) {
				quarters += 29;
				machine1 = 35;
			}else {
				machine1--;
				quarters--;
			}
			if(machine2 - 1 == 0 && quarters != 0) {
				quarters += 59;
				machine2 = 100;
			}else {
				machine2--;
				quarters--;
			}
			if(machine3 - 1 == 0 && quarters != 0) {
				quarters += 8;
				machine3 = 10;
			}else {
				machine3--;
				quarters--;
			}
			out.println(machine1 + " " + machine2 + " " + machine3);
			out.println(quarters);
			ans++;
		}
		
		out.println("Martha plays " + ans + " times before going broke.");
		out.flush();
	}

}
