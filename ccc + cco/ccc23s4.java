import java.util.*;
import java.io.*;

public class ccc23s4 {
	
	static List<edge>[] adj = new ArrayList[2005];
	static List<edge>[] adj2 = new ArrayList[2005];
	static edge[] edges;
	
	public static class edge implements Comparable<edge>{
		int u;
		int v;
		long length;
		long cost;
		
		public edge(int u, int v, long length, long cost) {
			this.u = u;
			this.v = v;
			this.length = length;
			this.cost = cost;
		}
		
		public int compareTo(edge other) {
			int compare = (int) Long.compare(this.length, other.length);
			if(compare == 0) return Long.compare(this.cost, other.cost);
			else return compare;
		}
	}
	
	
	public static long dijkstra(int src, int dest) {
		PriorityQueue<edge> pq = new PriorityQueue<>();
		long[] step = new long[2005];
		
		Arrays.fill(step, Integer.MAX_VALUE);
		pq.add(new edge(src, src, 0, 0));
		step[src] = 0;
		
		while(!pq.isEmpty()) {
			edge cur = pq.poll();
    		
    		for(edge next : adj2[cur.v]) {
    			if(step[cur.v]+next.length < step[next.v]) {
    				step[next.v] = step[cur.v]+next.length;
    				pq.add(next);
    			}
    		}
		}
		
		return step[dest];
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        edges = new edge[M];
        for(int i = 0; i < 2005; ++i) {
        	adj[i] = new ArrayList<>();
        	adj2[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; ++i) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        	long l = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        	adj[a].add(new edge(a, b, l, c));
        	adj[b].add(new edge(b, a, l, c));
        	edges[i] = new edge(a, b, l, c);
        }
    
        
        Arrays.sort(edges);
        long ans = 0;
        for(edge cur : edges) {      	
        	long before = dijkstra(cur.u, cur.v);
        	adj2[cur.u].add(cur);
    		adj2[cur.v].add(new edge(cur.v, cur.u, cur.length, cur.cost));
        	long after = dijkstra(cur.u, cur.v);
        	
        	if(after < before) {
        		ans += cur.cost;
        	}else {
        		adj2[cur.u].remove(adj2[cur.u].size()-1);
        		adj2[cur.v].remove(adj2[cur.v].size()-1);
        	}
        }
        
        System.out.println(ans);
    }

}