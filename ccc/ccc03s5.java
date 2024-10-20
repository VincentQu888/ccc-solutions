import java.util.*;
import java.io.*;

public class ccc03s5 {
	
	static int[] parent;
	static int[] size;
	
	public static class edge implements Comparable<edge>{
		int u;
		int v;
		int weight;
		
		public edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
		
		public int compareTo(edge other) {
			return other.weight-this.weight;
		}
	}
	
	public static int find(int u) {
		if(parent[u] == u) return u;
		return parent[u] = find(parent[u]);
	}
	
	public static void combine(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(size[u] > size[v]) {
			parent[v] = u;
			size[u] += v;
		}else {
			parent[u] = v;
			size[v] += u;
		}
	}

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
		
		List<edge>[] adj = new ArrayList[c];
		Queue<edge> queue = new LinkedList<>();
		edge[] edges = new edge[r];
		parent = new int[c];
		size = new int[c];
		int[] step = new int[c];
		int[] dest = new int[d];
		
		for(int i = 0; i < c; i++) {
			adj[i] = new ArrayList<>();
			parent[i] = i;
			size[i] = 1;
		}
		
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			edges[i] = new edge(u, v, weight);
		}
		
		for(int i = 0; i < d; i++) {
			dest[i] = Integer.parseInt(br.readLine())-1;
		}
		
		
		Arrays.sort(edges);
		for(edge next : edges) {
			if(find(next.v) != find(next.u)) {
				combine(next.u, next.v);
				
				adj[next.u].add(new edge(next.u, next.v, next.weight));
				adj[next.v].add(new edge(next.v, next.u, next.weight));
			}
		}
		
		
		queue.add(new edge(0, 0, 0));
		while(!queue.isEmpty()) {
			edge cur = queue.poll();
			
			for(edge next : adj[cur.v]) {
				if(step[next.v] == 0) {
					queue.add(next);
					step[next.v] = Math.min(step[cur.v], next.weight);
					if(step[next.v] == 0) step[next.v] = next.weight;
				}
			}
		}
		
		
		for(int destination : dest) {
			if(step[destination] < ans) ans = step[destination];
		}
		out.println(ans);
		out.flush();
	}

}