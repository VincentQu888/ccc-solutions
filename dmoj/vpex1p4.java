import java.util.*;
import java.io.*;
	
public class vpex1p4 {
	
	public static class pair<K, V> {
		K key;
		V value;
		
		public pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K first() {
			return key;
		}
		
		public V second() {
			return value;
		}
	}
	
	public static class edge implements Comparable<edge>{
		int u;
	    int v;
	    int weight;

	    public edge(int u, int v, int weight) {
	    	this.u = u;
	    	this.v = v;
	    	this.weight = weight;
	    }
	    
	    public int compareTo(edge other){
	        return this.weight - other.weight;
	    }
	}

	static ArrayList<edge>[] adj = new ArrayList[100005];
	static ArrayList<Integer> euler = new ArrayList<>();
	static int[] depth = new int[100005];
	static long[] dist = new long[100005];
	static int[] in = new int[100005];
	static pair<Integer, Integer>[][] sparse = new pair[2*100000+5][18];
	    
	public static void dfs(edge cur){
	    euler.add(cur.v);

	    for(edge next : adj[cur.v]){
	        if(depth[cur.v] + 1 < depth[next.v]){
	            depth[next.v] = depth[cur.v] + 1;
	            if(in[next.v] == -1) in[next.v] = euler.size();
	            dfs(next);
	            euler.add(next.v);
	        }
	    }
	}

	public static int query(int L, int R){
	    int j = (int)log2(R - L + 1);
	 
	    if (sparse[L][j].first() <= sparse[R - (1 << j) + 1][j].first()) return sparse[L][j].second();
	    else return sparse[R - (1 << j) + 1][j].second();
	}

	public static int log2(int n) {
		return (int)(Math.log(n)/Math.log(2));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; ++i) {
        	adj[i] = new ArrayList<>();
        }
	    for(int i = 0; i < N-1; ++i){
	    	st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
	        --a; --b;
	        adj[a].add(new edge(a, b, c));
	        adj[b].add(new edge(b, a, c));
	    }


	    Arrays.fill(depth, Integer.MAX_VALUE);
	    depth[0] = 0;
	    dfs(new edge(0, 0, 0));

	    for(int i = 0; i < sparse.length; ++i) {
	    	for(int j = 0; j < sparse[0].length; ++j) {
	    		sparse[i][j] = new pair(0, 0);
	    	}
	    }
	    for(int i = 1; i < euler.size(); ++i) 
	        sparse[i][0] = new pair(depth[euler.get(i)], euler.get(i));
	    for(int j = 1; j <= log2(euler.size()); ++j) {
	        for(int i = 1; i + (1 << j) - 1 <= euler.size(); i++) {
	            if (sparse[i][j - 1].first() < sparse[i + (1 << (j - 1))][j - 1].first()) sparse[i][j] = sparse[i][j - 1];
	            else sparse[i][j] = sparse[i + (1 << (j - 1))][j - 1];
	        }
	    }


	    Arrays.fill(dist, Long.MAX_VALUE);
	    PriorityQueue<edge> pq = new PriorityQueue<>();
	    pq.add(new edge(0, 0, 0));
	    dist[0] = 0;
	    while(!pq.isEmpty()){
	        edge cur = pq.poll();
	        
	        for(edge next : adj[cur.v]){
	            if(dist[cur.v] + next.weight < dist[next.v]){
	                dist[next.v] = dist[cur.v] + next.weight;
	                pq.add(next);
	            }
	        }
	    }


	    int cur = 0;
	    long ans = 0;
	    for(int i = 0; i < D; ++i){
	    	st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
	        --x; --y;

	        long distx, disty, distxy;
	        if(in[x] < in[cur]){
	            distx = dist[x] + dist[cur] - 2*dist[query(x, cur)];
	        }else{
	            distx = dist[x] + dist[cur] - 2*dist[query(cur, x)];
	        }
	        
	        if(in[y] < in[cur]){
	            disty = dist[y] + dist[cur] - 2*dist[query(y, cur)];
	        }else{
	            disty = dist[y] + dist[cur] - 2*dist[query(cur, y)];
	        }

	        if(in[x] < in[y]){
	            distxy = dist[x] + dist[y] - 2*dist[query(x, y)];
	        }else{
	            distxy = dist[x] + dist[y] - 2*dist[query(y, x)];
	        }

	        ans += Math.min(distx + distxy, disty + distxy);
	        if(distx + distxy < disty + distxy) cur = y;
	        else cur = x;
	    }

	    System.out.println(ans);
	}
}
