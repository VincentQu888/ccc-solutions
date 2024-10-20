import java.util.*;
import java.io.*;

public class ccc07s3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> adj = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		boolean loop = true;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			adj.put(x, y);
		}
		
		
		while(loop) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			HashMap<Integer, Integer> step = new HashMap<>();
			
			if(start == 0 && end == 0) {
				break;
			}else {
				queue.add(start);
				
				while(!queue.isEmpty()) {				
					int current = queue.poll();
					
					if(adj.get(current) != null) {
						if(step.get(current) == null) {
							step.put(current, 0);
						}
						if(step.get(adj.get(current)) == null) {
							step.put(adj.get(current), 0);
						}
						if(step.get(current)+1 < step.get(adj.get(current)) || step.get(adj.get(current)) == 0) {
							queue.add(adj.get(current));
							step.put(adj.get(current), step.get(current)+1);
						}
					}
				}
				
				if(step.get(end) == null) {
					out.println("No");
				}else {
					out.println("Yes " + (step.get(end)-1));
				}
			}
		}
		
		out.flush();
	}

}
