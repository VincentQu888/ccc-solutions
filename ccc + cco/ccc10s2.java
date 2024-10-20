import java.util.*;
import java.io.*;

public class ccc10s2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int K = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String character = st.nextToken();
            String needle = st.nextToken();
            map.put(needle, character);
        }
        
        String haystack = br.readLine();
        ArrayList<String> arr = new ArrayList<>();
        int counter = 0;
        
        while (haystack.length() != 0) {
            String str = haystack.substring(0, counter);
            if (map.containsKey(str)) {
                arr.add(map.get(str));
                haystack = haystack.substring(counter);
                counter = 0;
            }
            counter++;
            if(counter == haystack.length()) {
            	arr.add(map.get(haystack));
            	break;
            }
        }
        
        for (int i = 0; i < arr.size(); i++) {
            out.print(arr.get(i));
        }
        out.flush();
	}

}
