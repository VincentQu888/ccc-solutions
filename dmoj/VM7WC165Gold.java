import java.util.*;
import java.io.*;

public class VM7WC165Gold {
	
	static ArrayList<Integer>[] adjlist;
	static boolean[] visited;
	static int step[];
	
	public static void dfs(int current) {
		for (int next: adjlist[current]){ 
			if (!visited[next]){
				visited[next] = true;
				step[next] = step[current] + 1;
		        dfs(next);
		    }
		}
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> stepCounts = new ArrayList<>();
		
		adjlist = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i < adjlist.length; i++){
			adjlist[i] = new ArrayList<Integer>(); 
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			adjlist[x].add(y);
			adjlist[y].add(x);
		}
		
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			if(adjlist[i] != null) {
				dfs(i);
				Arrays.sort(step);
				stepCounts.add(step[step.length]);
				Arrays.fill(visited, false);
			}else {
				stepCounts.add(0);
			}
		}
		System.out.println(Collections.max(stepCounts));
	}

}
