import java.util.*;
import java.io.*;

public class ccc03s5 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int ans = Integer.MAX_VALUE;
		
		HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		int[] step = new int[c+1];
		
		for(int i = 0; i < c+1; i++) {
			graph.put(i, new ArrayList<>());
		}

		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(new int[] {y, weight});
			graph.get(y).add(new int[] {x, weight});
		}
		
		
		queue.add(1);
		
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			
			for(int next = 0; next < graph.get(current).size(); next++) {
				if(graph.get(current).get(next)[1] > step[graph.get(current).get(next)[0]]) {
					queue.add(graph.get(current).get(next)[0]);
					step[graph.get(current).get(next)[0]] = graph.get(current).get(next)[1];
				}
			}
		}
		
		for(int i = 0; i < d; i++) {
			int city = Integer.parseInt(br.readLine());
			if(step[city] < ans) {
				ans = step[city];
			}
		}
		
		out.println(ans);
		out.flush();
	}

}