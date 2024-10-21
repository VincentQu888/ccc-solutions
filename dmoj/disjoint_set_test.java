import java.util.*;
import java.io.*;

public class disjoint_set_test{
	
	public static class edge{
		int u;
		int v;
		
		public edge(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}
	
	public static int find(int u, int[] parent) {
		if(u == parent[u]) return u;
		parent[u] = find(parent[u], parent);
		return parent[u];
	}
	
	public static void combine(int u, int v, int[] parent) {
		u = find(u, parent);
		v = find(v, parent);
		
		if(u != v) parent[v] = u;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> ans = new ArrayList<>();
		edge[] edges = new edge[M];
		int[] parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			
			edges[i] = new edge(u, v);
		}
		
		
		int counter = 0;
		for(int i = 0; i < M; i++) {
			if(find(edges[i].u, parent) != find(edges[i].v, parent)) {
				combine(edges[i].u, edges[i].v, parent);
				ans.add(i);
				
				counter++;
			}
			
			if(counter == N-1) {
				break;
			}
		}
		
		if (ans.size() != N - 1) System.out.println("Disconnected Graph");
		else{
			for(int i = 0; i < ans.size(); i++) {
				System.out.println(ans.get(i)+1);
			}
		}
	}
	
}