import java.io.*;
import java.util.*;

public class COCI14contest2p2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> contestants = new HashSet<>();
		HashMap<String, Character> contestants2 = new HashMap<>();

		for (int i = 0; i < 2*N - 1; i++) {
            String str = br.readLine();
            if (contestants2.get(str) == null) {
            	contestants.add(str);
            	contestants2.put(str, 'a');
            }else { 
                contestants.remove(str);
            	contestants2.remove(str);
            }
		}
		
		String arr = contestants.toString();
	    String arr2 = arr.substring(1, arr.length() - 1);
	    System.out.println(arr2);

	}
}