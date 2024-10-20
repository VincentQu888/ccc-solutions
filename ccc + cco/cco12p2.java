import java.util.*;
import java.io.*;

public class cco12p2 {
	
	public static class edge{
		int dest;
		int weight;
		
		public edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}

	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        List<edge>[] adj = new ArrayList[N];
        Queue<edge> pq = new LinkedList<>();
        int[][] step = new int[N][2];
        for(int i = 0; i < N; i++) {
        	adj[i] = new ArrayList<>();
        	step[i][0] = Integer.MAX_VALUE;
        	step[i][1] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken())-1,
        	B = Integer.parseInt(st.nextToken())-1,
        	L = Integer.parseInt(st.nextToken());
        	
        	adj[A].add(new edge(B, L));
        	adj[B].add(new edge(A, L));
        }
        
        
        pq.add(new edge(0, 0));
        step[0][0] = 0;
        step[0][1] = 0;
        
        while(!pq.isEmpty()) {
        	edge cur = pq.poll();
        	boolean added = false;
        	
        	for(edge next : adj[cur.dest]) {	
            	if(step[cur.dest][0]+next.weight < step[next.dest][0]) {
            		step[next.dest][1] = step[next.dest][0];
            		step[next.dest][0] = step[cur.dest][0]+next.weight;
            		pq.add(new edge(next.dest, step[next.dest][0]));
            		added = true;
            	}
            	if((step[cur.dest][0]+next.weight < step[next.dest][1] || step[next.dest][1] == 0) && step[cur.dest][0]+next.weight > step[next.dest][0]){
            		step[next.dest][1] = step[cur.dest][0]+next.weight;
            		pq.add(new edge(next.dest, step[next.dest][0]));
            		if(!added) added = true;
            	}
            	if((step[cur.dest][1]+next.weight < step[next.dest][1] || step[next.dest][1] == 0) && step[cur.dest][1] != Integer.MAX_VALUE && step[cur.dest][1]+next.weight > step[next.dest][0]){
            		step[next.dest][1] = step[cur.dest][1]+next.weight;
            		if(!added) pq.add(new edge(next.dest, step[next.dest][0]));
            	}
            }
        }
        
        if(step[N-1][1] == Integer.MAX_VALUE) out.println(-1);
        else out.println(step[N-1][1]);
        out.flush();
    }

}