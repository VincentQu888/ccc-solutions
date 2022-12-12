import java.util.*;
import java.io.*;

public class ccc18j5 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int pages = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		HashSet<Integer> ends = new HashSet<>();
		int[] step = new int[pages+1];
		int ans = Integer.MAX_VALUE;
		boolean reachable = true;
		
		for(int i = 0; i <= pages; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= pages; i++) {
			st = new StringTokenizer(br.readLine());
			
			int connections = Integer.parseInt(st.nextToken());
			if(connections == 0) {
				ends.add(i);
			}
			
			for(int j = 0; j < connections; j++) {
				adj.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		queue.add(1);
		step[1] = 1;
		
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			
			for(int i = 0; i < adj.get(current).size(); i++) {
				if(step[current]+1 < step[adj.get(current).get(i)] || step[adj.get(current).get(i)] == 0) {
					queue.add(adj.get(current).get(i));
					step[adj.get(current).get(i)] = step[current]+1;
				}
			}
		}
		
		
		for(int i = 1; i <= pages; i++) {
			if(step[i] < ans && ends.contains(i) && step[i] != 0) {
				ans = step[i];
			}
			
			if(step[i] == 0) {
				reachable = false;
			}
		}
		
		if(!reachable) {
			out.println("N");
		}else {
			out.println("Y");
		}
		out.println(ans);
		out.flush();
	}

}
