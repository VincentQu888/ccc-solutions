import java.util.*;
import java.io.*;

public class apio08p2 {
	
	static int[] parent;
	static int[] size;
	
	public static class edge{
		int u;
		int v;
		int c;
		
		public edge(int u, int v, int c) {
			this.u = u;
			this.v = v;
			this.c = c;
		}
	}
	
	
	public static int find(int u) {
		if(parent[u] == u) return u;
		return parent[u] = find(parent[u]);
	}
	
	public static void union(int u, int v) {
		if(u == v) return;
		
		u = find(u);
		v = find(v);
		
		if(size[u] > size[v]) {
			parent[v] = u;
			size[u] += size[v];
		}else {
			parent[u] = v;
			size[v] += size[u];
		}
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        
        List<edge>[] adj = new ArrayList[N];
        ArrayList<edge> cobble = new ArrayList<>();
        ArrayList<edge> concrete = new ArrayList<>();
        parent = new int[N];
        size = new int[N];
        int[] subgraph = new int[N];
        for(int i = 0; i < N; ++i) {
        	parent[i] = i;
        	size[i] = 1;
        	adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; ++i) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken())-1, v = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken());
        	
        	if(c == 0) cobble.add(new edge(u, v, c));
        	else {
        		concrete.add(new edge(u, v, c));
        		adj[u].add(new edge(u, v, c));
        		adj[v].add(new edge(v, u, c));
        	}
        }
        
        
        Queue<edge> queue = new LinkedList<>();
        int counter = 1;
        for(int i = 0; i < N; ++i) {
        	if(subgraph[i] != 0) continue;

        	queue.add(new edge(0, i, 1));
    		subgraph[i] = counter;
    		while(!queue.isEmpty()) {
    			edge cur = queue.poll();
    			
    			for(edge next : adj[cur.v]) {
    				if(subgraph[next.v] == 0) {
    					queue.add(next);
    					subgraph[next.v] = counter;
    				}
    			}
    		}
    		
    		++counter;
        }
        
        
        ArrayList<edge> ans = new ArrayList<>();
        HashSet<Integer> used = new HashSet<>();
        for(int i = 0; i < cobble.size(); ++i) {
        	edge next = cobble.get(i);
        	
        	if(subgraph[next.u] == subgraph[next.v]) continue;
        	if(find(next.u) != find(next.v)) {
        		union(next.u, next.v);
        		ans.add(next);
        		used.add(i);
        	}
        }
        
        counter = ans.size();
        for(int i = 0; i < cobble.size(); ++i) {
        	if(used.contains(i)) continue;
        	if(counter >= K) break;
        	
        	edge next = cobble.get(i);
        	if(find(next.u) != find(next.v)) {
        		union(next.u, next.v);
        		ans.add(next);
        		++counter;
        	}
        }
        
        for(edge next : concrete) {
        	if(find(next.u) != find(next.v)) {
        		union(next.u, next.v);
        		ans.add(next);
        	}
        }
        
        
        if(ans.size() == N-1 && counter == K) {
        	for(edge next : ans) System.out.println((next.u+1) + " " + (next.v+1) + " " + next.c);
        }else {
        	System.out.println("no solution");
        }
    }

}