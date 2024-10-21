import java.io.*;
import java.util.*;

public class timeOnTask {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalTime = Integer.parseInt(br.readLine());
		int numberOfChores = Integer.parseInt(br.readLine());
		int chores[] = new int [numberOfChores];
		int tally = 0;
		boolean loop = false;
		for(int i = 0; i < numberOfChores; i++) {
			chores[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(chores);
		while(loop == false) {
			if(totalTime - chores[tally] >= 0) {
				totalTime -= chores[tally];
				tally++;
			}else {
				System.out.println(tally);
				loop = true;
			}
		}
	}

}
