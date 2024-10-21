import java.util.*;
import java.io.*;

public class aqtDirectedGraph {
	
	static List<Integer>[] adj;
	static int[] visited;
	
	public static void dfs(int original, int cur) {
		for(int next : adj[cur]) {
			if(visited[next] == Integer.MAX_VALUE) {
				visited[next] = original;
				dfs(original, next);
			}
		}
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N];
        visited = new int[N];
        for(int i = 0; i < N; ++i) {
        	adj[i] = new ArrayList<>();
        	visited[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < M; ++i) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken())-1, v = Integer.parseInt(st.nextToken())-1;
        	
        	adj[v].add(u);
        }
        
        
        for(int i = N-1; i >= 0; --i) {
        	if(visited[i] == Integer.MAX_VALUE) {
        		visited[i] = i;
        		dfs(i, i);
        	}
        }
        
        boolean ans = false;
        for(int i = N-1; i >= 0 ; --i) {
        	if(visited[i] > i) {
        		System.out.println((i+1) + " " + (visited[i]+1));
        		ans = true;
        		break;
        	}
        }
        
        if(!ans) System.out.println(-1);
    }

}