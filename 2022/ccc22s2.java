import java.util.*;
import java.io.*;

public class ccc22s2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int violations = 0;
		int x = Integer.parseInt(br.readLine());
		String[][] together = new String[x][2];
		for(int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			together[i][0] = st.nextToken();
			together[i][1] = st.nextToken();
		}

		int y = Integer.parseInt(br.readLine());
		String[][] seperated = new String[y][2];
		for(int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			seperated[i][0] = st.nextToken();
			seperated[i][1] = st.nextToken();
		}
		
		int g = Integer.parseInt(br.readLine());
		HashMap<String, ArrayList<String>> groups = new HashMap<>();
		for(int i = 0; i < g; i++) {
			st = new StringTokenizer(br.readLine());
			String group1 = st.nextToken();
			String group2 = st.nextToken();
			String group3 = st.nextToken();
			
			groups.put(group1, new ArrayList<>());
			groups.get(group1).add(group2);
			groups.get(group1).add(group3);

			groups.put(group2, new ArrayList<>());
			groups.get(group2).add(group1);
			groups.get(group2).add(group3);
			
			groups.put(group3, new ArrayList<>());
			groups.get(group3).add(group1);
			groups.get(group3).add(group2);
		}
		
		for(int i = 0; i < x; i++) {
			if(!groups.get(together[i][0]).contains(together[i][1])) {
				violations++;
			}
		}
		for(int i = 0; i < y; i++) {
			if(groups.get(seperated[i][0]).contains(seperated[i][1])) {
				violations++;
			}
		}
		
		out.println(violations);
		out.flush();
	}

}
