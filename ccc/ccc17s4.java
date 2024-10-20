import java.util.*;

import unfinished.tenp.edge;

import java.io.*;

public class ccc17s4 {

	public static class edge implements Comparable<edge>{
		int u;
		int v;
		long weight;
		boolean active;
		
		public edge(int u, int v, long weight, boolean active) {
			this.u = u;
			this.v = v;
			this.weight = weight;
			this.active = active;
		}
		
		public int compareTo(edge other) {
		    return Long.compare(this.weight, other.weight);
		}
	}
	
	
	public static int find(int u, int[] parent) {
		if(parent[u] == u) return u;
		
		parent[u] = find(parent[u], parent);
		return parent[u];
	}
	
	
	public static void union(int u, int v, int[] parent, int[] size) {
		u = find(u, parent);
		v = find(v, parent);
		
		if (u != v) {
	        if (size[u] > size[v]) {
	        	parent[v] = u;
	            size[u] += size[v];
	        }else {
	        	parent[u] = v;
	            size[v] += size[u];
	        }
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
		int D = Integer.parseInt(st.nextToken());
		
		edge[] edges = new edge[M];
		int[] parent = new int[N];
		int[] size = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		
		long max = 0;
		int ans = 0;
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			int C = Integer.parseInt(st.nextToken());
			
			if(i < N-1) edges[i] = new edge(A, B, C, true);	
			else edges[i] = new edge(A, B, C, false);
		}
		Arrays.sort(edges);
		
		
		for(edge next : edges) {
			if(find(next.u, parent) != find(next.v, parent)) {
				union(next.u, next.v, parent, size);
				
				if(next.weight > max) max = next.weight;
				if(!next.active) ans++;
			}
		}
		
		
		if(D == 0) out.println(ans);
		else {
			for(int i = 0; i < N; i++) {
				parent[i] = i;
				size[i] = 1;
			}
			
			for(edge next : edges) {
				if(find(next.u, parent) != find(next.v, parent)) {
					if(next.weight < max || (next.weight == max && next.active)) union(next.u, next.v, parent, size);
					else if(next.weight <= D && next.active) {
						ans--;
						break;
					}
				}
			}
			out.println(ans);
		}
		out.flush();
	}

}
