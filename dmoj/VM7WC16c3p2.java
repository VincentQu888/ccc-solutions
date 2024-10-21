import java.util.*;
import java.io.*;

public class VM7WC16c3p2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[N+1];
			boolean[][] graph = new boolean[N+1][N+1];
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				graph[x][y] = graph[y][x] = true;
			}
			
			visited[A] = true;
			queue.add(A);
			
			while(!queue.isEmpty()) {
				int u = queue.poll();
				for(int v = 1; v <= N; v++) {
					if(graph[u][v] == true && !visited[v]){
						visited[v] = true;
						queue.add(v);
					}
				}
			}
			
			if(visited[B]) {
				System.out.println("GO SHAHIR!");
			}else {
				System.out.println("NO SHAHIR!");
			}
	}

}
