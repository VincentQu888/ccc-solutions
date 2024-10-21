import java.util.*;
import java.io.*;

public class dpg {
	
	static List<Integer>[] adj;
	static Deque<Integer> stack = new LinkedList<>();
	static boolean[] visited;
	
	public static void topo(int cur) {
		visited[cur] = true;
		
		for(int next : adj[cur]) {
			if(!visited[next]) topo(next);
		}
		
		stack.add(cur);
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N];
      	visited = new boolean[N];
        
        for(int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken())-1;
        	int v = Integer.parseInt(st.nextToken())-1;
        	
        	adj[u].add(v);
        }
        
        for(int i = 0; i < N; i++) {
        	if(!visited[i]) {
            	topo(i);
        	}
        }
        
        
        int[] step = new int[N];
        int max = 0;
        
        while(!stack.isEmpty()) {
        	int cur = stack.pollLast();
        	
        	for(int next : adj[cur]) {
        		step[next] = Math.max(step[next], step[cur]+1);
            	max = Math.max(max, step[next]);
        	}
        }
       

        out.println(max);
        out.flush();
    }

}