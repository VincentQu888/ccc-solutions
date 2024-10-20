import java.util.*;
import java.io.*;

public class ccc12s3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(br.readLine());
		int highestFreq = 1;
		int secondHighestFreq = 1;
		int[] freq = new int[1001];
		ArrayList<Integer> highFreqs = new ArrayList<>();
		ArrayList<Integer> secondHighFreqs = new ArrayList<>();
		
		
		for(int i = 0; i < N; i++) {
			int sensor = Integer.parseInt(br.readLine());
			freq[sensor]++;
			
			if(freq[sensor] > highestFreq) {
				highestFreq = freq[sensor];
			}
		}
		
		for(int i = 0; i < 1001; i++) {
			if(freq[i] > secondHighestFreq && freq[i] < highestFreq) {
				secondHighestFreq = freq[i];
			}
		}
		
		for(int i = 0; i < 1001; i++) {
			if(freq[i] == highestFreq) {
				highFreqs.add(i);
			}
			if(freq[i] == secondHighestFreq) {
				secondHighFreqs.add(i);
			}
		}
		
		highFreqs.sort(null);
		secondHighFreqs.sort(null);
		
		
		if(highFreqs.size() >= 2) {
			out.println(highFreqs.get(highFreqs.size()-1)-highFreqs.get(0));
		}else {
			out.println(Math.max(Math.max(highFreqs.get(0), highFreqs.get(highFreqs.size()-1)) - Math.min(secondHighFreqs.get(0), secondHighFreqs.get(secondHighFreqs.size()-1)), Math.max(secondHighFreqs.get(0), secondHighFreqs.get(secondHighFreqs.size()-1)) - Math.min(highFreqs.get(0), highFreqs.get(highFreqs.size()-1))));
		}
		//sorry for really dumb print statement i think i was drunk (tired) when writing this lmfao
		out.flush();
	}

}
