import java.util.*;
import java.io.*;

public class dmpg15s6 {
	
	static HashMap<String, ArrayList<edge>> adj = new HashMap<>();
	static HashSet<String> cycles = new HashSet<>();
	static HashSet<String> visited = new HashSet<>();
	static HashMap<String, String> parent = new HashMap<>();
	static HashMap<String, Integer> size = new HashMap<>();
	
	
	public static class edge{
		String dest;
		double rate;
		public edge(String dest, double rate) {
			this.dest = dest;
			this.rate = rate;
		}
	}
	
	
	public static boolean find(String u) {
		Queue<edge> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		
		queue.add(new edge(u, 1));
		while(!queue.isEmpty()) {
			edge cur = queue.poll();
			
			for(edge next : adj.get(cur.dest)) {
				if(!visited.contains(next.dest)) {
					queue.add(next);
					visited.add(next.dest);
					if(next.dest.equals("APPLES")) return true;
				}
			}
		}
		
		return false;
	}
	
	
	public static void detect(String cur) {
		for(edge next : adj.get(cur)) {
			if(visited.contains(next.dest))	cycles.add(next.dest);
			else {
				visited.add(next.dest);
				detect(next.dest);
			}
		}
	}
	
	public static boolean dfs(String cur, String start, double fruit) {
		if(cur.equals(start) && fruit > 1.001) return true;
		
		boolean ans = false;
		
		for(edge next : adj.get(cur)) {
			if(!visited.contains(next.dest) || next.dest.equals(start)) {
				visited.add(next.dest);
				ans = dfs(next.dest, start, fruit*next.rate) ? true : ans;
			}
		}
		
		return ans;
	}
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        boolean ans = false;
        
        for(int i = 0; i < N; i++) {
        	String fruit = br.readLine();
        	
        	adj.put(fruit, new ArrayList<>());
        }
        
        for(Map.Entry<String, ArrayList<edge>> next : adj.entrySet()) {
        	parent.put(next.getKey(), next.getKey());
        	size.put(next.getKey(), 1);
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	String src = st.nextToken(), 
        	dest = st.nextToken();
        	double rate = Double.parseDouble(st.nextToken());
        	
        	adj.get(src).add(new edge(dest, rate));
        }
        
        
        for(Map.Entry<String, ArrayList<edge>> next : adj.entrySet()) {
        	visited.add(next.getKey());
        	detect(next.getKey());
        	visited = new HashSet<>();
        }
        

        for(String next : cycles) {
        	if(find(next)) {
        		visited.add(next);
        		if(dfs(next, next, 1)) ans = true;
        		visited = new HashSet<>();
        	}
        }
        
        if(ans) out.println("YA");
        else out.println("NAW");
        out.flush();
    }

}