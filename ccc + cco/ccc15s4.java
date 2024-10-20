import java.util.*;
import java.io.*;

public class ccc15s4 {
	
	public static class edge implements Comparable<edge>{
		int dest;
		int weight;
		int wear;
		
		public edge(int dest, int weight, int wear) {
			this.dest = dest;
			this.weight = weight;
			this.wear = wear;
		}
		
		public int compareTo(edge other) {
			return this.weight - other.weight;
		}
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()), 
		N = Integer.parseInt(st.nextToken()), 
		M = Integer.parseInt(st.nextToken());
			
		ArrayList<edge>[] adj = new ArrayList[N];
		int[][] step = new int[N][K+1];
		for(int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
			Arrays.fill(step[i], Integer.MAX_VALUE);
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1,
			b = Integer.parseInt(st.nextToken())-1,
			t = Integer.parseInt(st.nextToken()),
			h = Integer.parseInt(st.nextToken());
			
			adj[a].add(new edge(b, t, h));
			adj[b].add(new edge(a, t, h));
		}
		
		st = new StringTokenizer(br.readLine());
		int src = Integer.parseInt(st.nextToken())-1, dest = Integer.parseInt(st.nextToken())-1;
		step[src][K] = 0;
		
		
		Queue<edge> pq = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();
		pq.add(new edge(src, 0, 0));
		queue.add(K);
		while(!pq.isEmpty()) {
			edge cur = pq.poll();
			int hull = queue.poll(); 
			
			for(edge next : adj[cur.dest]) {
				if(hull-next.wear > 0) {
					if(step[cur.dest][hull]+next.weight < step[next.dest][hull-next.wear]) {
						step[next.dest][hull-next.wear] = step[cur.dest][hull] + next.weight;
						pq.add(next);
						queue.add(hull-next.wear);
					}
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int next : step[dest]) ans = Math.min(ans, next);
		if(ans != Integer.MAX_VALUE) out.println(ans);
		else out.println(-1);
		out.flush();
	}

}