import java.util.*;
import java.io.*;

public class wac5p4 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        
        List<Integer>[] adj = new ArrayList[N];
        int[] step = new int[N];
        Arrays.fill(step, Integer.MAX_VALUE);
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken())-1, v = Integer.parseInt(st.nextToken())-1;
        	
        	adj[u].add(v);
        	adj[v].add(u);
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        step[0] = 0;
        queue.add(0);
        
        while(!queue.isEmpty()) {
        	int cur = queue.poll();
        	
        	for(int next : adj[cur]) {
        		if(step[cur]+1 < step[next]) {
        			step[next] = step[cur]+1;
        			queue.add(next);
        		}
        	}
        }
        
        
        for(int i = 0; i < Q; i++) {
        	
        }
    }

}