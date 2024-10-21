import java.util.*;
import java.io.*;

public class single_source_shortest_path{
	
	public static class edge implements Comparable<edge> {
		int dest;
		int weight;
		
		public edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<edge> pq = new PriorityQueue<>();
		List<edge>[] adj = new ArrayList[N];
		int[] step = new int[N];
		for(int i = 0; i < N; i++) adj[i] = new ArrayList<>();
		Arrays.fill(step, Integer.MAX_VALUE);
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1, 
			v = Integer.parseInt(st.nextToken())-1,
			weight = Integer.parseInt(st.nextToken());
			
			adj[u].add(new edge(v, weight));
			adj[v].add(new edge(u, weight));
		}
		
		
		pq.add(new edge(0, 0));
		step[0] = 0;
		
		while(!pq.isEmpty()) {
			edge current = pq.poll();
			
			for(edge next : adj[current.dest]) {
				if(step[current.dest]+next.weight < step[next.dest]) {
					step[next.dest] = step[current.dest]+next.weight;
					pq.add(next);
				}
			}
			
		}
		
		
		for(int i = 0; i < N; i++) {
			if(step[i] == Integer.MAX_VALUE) out.println(-1);
			else out.println(step[i]);
		}
		
		out.flush();
	}

}
