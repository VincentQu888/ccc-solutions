import java.util.*;
import java.io.*;

public class ccc15s4UNFINISHED {
	
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
	
	public static void dijkstra(ArrayList<edge>[] adj, int[] step, edge current, int hull) { //does not take into account cases where the step value to a node is slower, but is the correct pathway - 14/15 on dmoj (official ccc testcases)
		for(edge next: adj[current.dest]) {
			if(step[current.dest]+next.weight < step[next.dest] && hull-next.wear > 0) {
				step[next.dest] = step[current.dest] + next.weight;
				hull -= next.wear;
				dijkstra(adj, step, next, hull);
				hull += next.wear;
			}
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
		int[] step = new int[N];
		for(int i = 0; i < N; i++) adj[i] = new ArrayList<>();
		Arrays.fill(step, Integer.MAX_VALUE);
		
		
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
		step[src] = 0;
		
		
		dijkstra(adj, step, new edge(src, 0, 0), K);
		
		if(step[dest] != Integer.MAX_VALUE) out.println(step[dest]);
		else out.println(-1);
		out.flush();
	}

}