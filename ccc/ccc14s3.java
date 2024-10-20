import java.util.*;
import java.io.*;

public class ccc14s3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tests = 0; tests < T; tests++) {
			int N = Integer.parseInt(br.readLine());
			int counter = 0;
			int[] input = new int[N];
			ArrayList<Integer> candy = new ArrayList<>();
			Stack<Integer> branch = new Stack<>();
			
			for(int i = 0; i < N; i++) {
				input[N-i-1] = Integer.parseInt(br.readLine());
			}
			
			for(int i = 0; i < N; i++) {
				if(input[i] == counter+1) {
					candy.add(input[i]);
					counter++;
				}else {
					if(branch.isEmpty()) {
						branch.add(input[i]);
					}else if(branch.peek() == counter+1) {
						candy.add(branch.pop());
						counter++;
						i--;
					}else {
						branch.add(input[i]);
					}
				}
			}
			while(!branch.isEmpty()) {
				candy.add(branch.pop());
			}
			
			counter = 0;
			for(int i = 0; i < candy.size(); i++) {
				if(candy.get(i) == i+1) {
					counter++;
				}
			}
			
			if(counter == N) {
				out.println("Y");
			}else {
				out.println("N");
			}
		}
		out.flush();
	}

}
