import java.util.*;
import java.io.*;

public class btoi16p4 { //niot odnee
	
	static HashSet<Integer> unecessary = new HashSet<>();
	static HashSet<Integer> important = new HashSet<>(); //note "unecessary" and "important" are not opposites
	static List<edge>[] adj;
	static int[] parent;
	static int[] size;
	static boolean[] visited;
	
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
			return this.weight-other.weight;
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
	
	public static boolean dfs(int src) {
		boolean ans = false;
		
		for(edge next : adj[src]) {
			if(!visited[next.v]) {
				visited[next.v] = true;
				
				if(!dfs(next.v)) unecessary.add(next.u);
				else ans = true;
			}
		}
		
		if(important.contains(src)) ans = true;
		return ans;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		edge[] edges = new edge[M];
		adj = new ArrayList[N];
		parent = new int[N];
		size = new int[N];
		visited = new boolean[N];
		long ans = 0;
		for(int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
			parent[i] = i;
			size[i] = 1;
		}
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			important.add(Integer.parseInt(st.nextToken())-1);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			edges[i] = new edge(u, v, weight);
		}
		
		
		int rdm = 0; //arbitrary node
		Arrays.sort(edges);
		for(int i = 0; i < M; i++) {
			if(find(edges[i].u) != find(edges[i].v)) {
				combine(edges[i].u, edges[i].v);
				rdm = edges[i].v;
				
				adj[edges[i].u].add(new edge(i, edges[i].v, edges[i].weight)); //kind of stupid but uses the "u" value to store the index cause we dont use "u" in the dfs and i need to store the index somewhere
				adj[edges[i].v].add(new edge(i, edges[i].u, edges[i].weight));
			}else {
				unecessary.add(i);
			}
		}
		
		visited[rdm] = true;
		dfs(rdm);
		
		
		for(int i = 0; i < M; i++) {
			if(!unecessary.contains(i)) ans += edges[i].weight;
		}
		out.println(ans);
		
		out.flush();
	}

}
